package nl.itris.decadeschermen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;
import nl.itris.decadeschermen.mysql.repository.EnvironmentRepository;
import nl.itris.decadeschermen.oracle.domain.DecadeSchermDefinitieTypeDao;
import nl.itris.decadeschermen.oracle.domain.ViewpointOrganizationDao;

@Controller
@RequestMapping("/schermdefinitiestypes")
public class SchermDefinitiesTypesController {

	private final EnvironmentRepository environmentRepository;

	DecadeEnvironment decadeEnvironment = new DecadeEnvironment();
    
    @Autowired
    public SchermDefinitiesTypesController(EnvironmentRepository environmentRepository) {
    	this.environmentRepository = environmentRepository;
    }

    
    @GetMapping("/environmentid/{environmentid}/verkortenaam/{verkortenaam}/niveau/{niveau}")
    public String showSchermDefinitiesTypes(
    		@PathVariable("environmentid") long environmentid, 
    		@PathVariable("verkortenaam") String verkortenaam, 
    		@PathVariable("niveau") int niveau, 
    		Model model) {
 
    	this.decadeEnvironment = environmentRepository.findById(environmentid).orElseThrow(() -> new IllegalArgumentException("Omgeving met ID: " + environmentid + " niet gevonden!"));
    	model.addAttribute("environment", this.decadeEnvironment);

    	ViewpointOrganizationDao viewpointOrganizationDao = new ViewpointOrganizationDao();
    	model.addAttribute("organization", viewpointOrganizationDao.findByRosid(this.decadeEnvironment));
    	 
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("authenticated", authentication);

    	DecadeSchermDefinitieTypeDao decadeSchermDefinitieTypeDao = new DecadeSchermDefinitieTypeDao();
    	model.addAttribute("schermdefinitiestypes", decadeSchermDefinitieTypeDao.findAllSchermDefinitieTypes(decadeEnvironment, verkortenaam, niveau));
    	
        return "schermdefinitiestypes-index";

    }
    
}