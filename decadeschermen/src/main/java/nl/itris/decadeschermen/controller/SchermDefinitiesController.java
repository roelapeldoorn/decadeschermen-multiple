package nl.itris.decadeschermen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/{environmentid}/", method = RequestMethod.GET)
    public String showSchermDefinities(@PathVariable("environmentid") long environmentid, Model model) {

    	this.decadeEnvironment = environmentRepository.findById(environmentid)
    			.orElseThrow(() -> new IllegalArgumentException("Omgeving met ID: " + environmentid + " niet gevonden!"));
    	model.addAttribute("environment", this.decadeEnvironment);

    	ViewpointOrganizationDao viewpointOrganizationDao = new ViewpointOrganizationDao();
    	model.addAttribute("organization", viewpointOrganizationDao.findByRosid(this.decadeEnvironment));
    	 
    	DecadeSchermDefinitieDao decadeSchermDefinitieDao = new DecadeSchermDefinitieDao();
    	model.addAttribute("schermdefinities", decadeSchermDefinitieDao.findAllSchermDefinities(this.decadeEnvironment, this.zoekSchermDefinitie));
 
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("authenticated", authentication);

        model.addAttribute("zoekschermdefinitie", new DecadeSchermDefinitie());

        return "schermdefinities-index";
    	
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String searchSchermDefinities(@RequestParam(value = "search", required = false) String q, Model model) {

    	this.zoekSchermDefinitie = q.toUpperCase().trim();
    	
    	System.out.println("Omgeving : " + this.decadeEnvironment.getEnvironmentcode());
    	System.out.println("Zoek naar: " + this.zoekSchermDefinitie);

    	
    	model.addAttribute("search", this.zoekSchermDefinitie);
    	model.addAttribute("environment", this.decadeEnvironment);

    	ViewpointOrganizationDao viewpointOrganizationDao = new ViewpointOrganizationDao();
    	model.addAttribute("organization", viewpointOrganizationDao.findByRosid(this.decadeEnvironment));
    	 
    	DecadeSchermDefinitieDao decadeSchermDefinitieDao = new DecadeSchermDefinitieDao();
    	model.addAttribute("schermdefinities", decadeSchermDefinitieDao.findAllSchermDefinities(this.decadeEnvironment, this.zoekSchermDefinitie));
 
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("authenticated", authentication);
    	
        model.addAttribute("zoekschermdefinitie", new DecadeSchermDefinitie());

        return "schermdefinities-index";
    	
    }

}