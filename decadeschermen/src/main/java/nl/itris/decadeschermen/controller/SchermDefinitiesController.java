package nl.itris.decadeschermen.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.itris.decadeschermen.config.OracleJdbcTemplateBuilder;
import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;
import nl.itris.decadeschermen.mysql.repository.EnvironmentRepository;
import nl.itris.decadeschermen.oracle.domain.DecadeSchermDefinitie;
import nl.itris.decadeschermen.oracle.domain.DecadeSchermDefinitieDao;
import nl.itris.decadeschermen.oracle.domain.ViewpointOrganizationDao;

@Controller
@RequestMapping("/schermdefinities")
public class SchermDefinitiesController {

	private final EnvironmentRepository environmentRepository;
	private String zoekSchermDefinitie;
    
    DecadeEnvironment decadeEnvironment = new DecadeEnvironment();
    
    @Autowired
    public SchermDefinitiesController(EnvironmentRepository environmentRepository) {
    	this.environmentRepository = environmentRepository;
    	this.zoekSchermDefinitie = "";
    }

    @GetMapping("/{environmentid}")
    public String showSchermDefinities(@PathVariable("environmentid") long environmentid, Model model) {

    	this.decadeEnvironment = environmentRepository.findById(environmentid)
    			.orElseThrow(() -> new IllegalArgumentException("Omgeving met ID: " + environmentid + " niet gevonden!"));
    	model.addAttribute("environment", this.decadeEnvironment);

    	OracleJdbcTemplateBuilder oracleJdbcTemplateBuilder = new OracleJdbcTemplateBuilder();
    	
    	ViewpointOrganizationDao viewpointOrganizationDao = new ViewpointOrganizationDao();
    	viewpointOrganizationDao.setJdbcTemplate(oracleJdbcTemplateBuilder.getJdbcTemplate(this.decadeEnvironment));
    	model.addAttribute("organization", viewpointOrganizationDao.findByRosid());

    	DecadeSchermDefinitieDao decadeSchermDefinitieDao = new DecadeSchermDefinitieDao();
    	decadeSchermDefinitieDao.setJdbcTemplate(oracleJdbcTemplateBuilder.getJdbcTemplate(this.decadeEnvironment));
    	model.addAttribute("schermdefinities", decadeSchermDefinitieDao.findAllSchermDefinities(this.zoekSchermDefinitie));
 
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("authenticated", authentication);

        model.addAttribute("zoekschermdefinitie", new DecadeSchermDefinitie());

        return "schermdefinities-index";
    	
    }
    
    @RequestMapping(value = "/zoeken/{stpdverkortenaam}", method=RequestMethod.POST)
    public String zoekSchermDefinities(@PathVariable("stpdverkortenaam") String stpdverkortenaam, @Valid DecadeSchermDefinitie decadeSchermDefinitie, BindingResult result, Model model) {

    	this.zoekSchermDefinitie = stpdverkortenaam;

    	System.out.println("Zoekterm " + this.zoekSchermDefinitie);

        return "schermdefinities-index";
        
    }

}