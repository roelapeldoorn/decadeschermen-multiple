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
import nl.itris.decadeschermen.oracle.domain.DecadeSchermDefinitieRubriekenDao;
import nl.itris.decadeschermen.oracle.domain.DecadeSchermDefinitieWerkVanuitDao;
import nl.itris.decadeschermen.oracle.domain.ViewpointOrganizationDao;

@Controller
@RequestMapping("/schermdefinitiesrubrieken")
public class SchermDefinitiesRubriekenController {

	private final EnvironmentRepository environmentRepository;

	DecadeEnvironment decadeEnvironment = new DecadeEnvironment();
    
    @Autowired
    public SchermDefinitiesRubriekenController(EnvironmentRepository environmentRepository) {
    	this.environmentRepository = environmentRepository;
    }

    
    @GetMapping("/environmentid/{environmentid}/verkortenaam/{verkortenaam}/niveau/{niveau}/type/{type}/werkVanuit/{werkVanuit}")
    public String showSchermDefinitiesRubrieken(
    		@PathVariable("environmentid") long environmentid, 
    		@PathVariable("verkortenaam") String verkortenaam, 
    		@PathVariable("niveau") int niveau, 
    		@PathVariable("type") String type, 
    		@PathVariable("werkVanuit") String werkVanuit, 
    		Model model) {

    	System.out.println("Rubrieken is aangeroepen voor: " + werkVanuit);
    	
    	this.decadeEnvironment = environmentRepository.findById(environmentid).orElseThrow(() -> new IllegalArgumentException("Omgeving met ID: " + environmentid + " niet gevonden!"));
    	model.addAttribute("environment", this.decadeEnvironment);

    	ViewpointOrganizationDao viewpointOrganizationDao = new ViewpointOrganizationDao();
    	model.addAttribute("organization", viewpointOrganizationDao.findByRosid(this.decadeEnvironment));
    	 
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("authenticated", authentication);

    	DecadeSchermDefinitieWerkVanuitDao decadeSchermDefinitieWerkVanuitDao = new DecadeSchermDefinitieWerkVanuitDao();
    	model.addAttribute("schermdefinitie", decadeSchermDefinitieWerkVanuitDao.findByVerkortenaamNiveauTypeAndWerkvanuit(
    			this.decadeEnvironment, 
    			verkortenaam, 
    			niveau, 
    			type, 
    			werkVanuit));

    	DecadeSchermDefinitieRubriekenDao decadeSchermDefinitieRubriekeDao = new DecadeSchermDefinitieRubriekenDao();
    	model.addAttribute("schermdefinitiesrubrieken", decadeSchermDefinitieRubriekeDao.findAllRubrieken(
    			this.decadeEnvironment, 
    			verkortenaam, 
    			niveau, 
    			type, 
    			werkVanuit));
    	
        return "schermdefinitiesrubrieken-index";

    }
    
}