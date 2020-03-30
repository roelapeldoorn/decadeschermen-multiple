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
import nl.itris.decadeschermen.oracle.domain.DecadeSchermDefinitieWerkVanuitDao;
import nl.itris.decadeschermen.oracle.domain.ViewpointOrganizationDao;

@Controller
@RequestMapping("/schermdefinitieswerkvanuit")
public class SchermDefinitiesWerkVanuitController {

	private final EnvironmentRepository environmentRepository;

	DecadeEnvironment decadeEnvironment = new DecadeEnvironment();
    
    @Autowired
    public SchermDefinitiesWerkVanuitController(EnvironmentRepository environmentRepository) {
    	this.environmentRepository = environmentRepository;
    }

    
    @GetMapping("/environmentid/{environmentid}/verkortenaam/{verkortenaam}/niveau/{niveau}/type/{type}")
    public String showSchermDefinitiesWerkVanuit(
    		@PathVariable("environmentid") long environmentid, 
    		@PathVariable("verkortenaam") String verkortenaam, 
    		@PathVariable("niveau") int niveau, 
    		@PathVariable("type") String type, 
    		Model model) {

    	System.out.println("WerkVanuit is aangeroepen voor: " + type);
    	
    	this.decadeEnvironment = environmentRepository.findById(environmentid).orElseThrow(() -> new IllegalArgumentException("Omgeving met ID: " + environmentid + " niet gevonden!"));
    	model.addAttribute("environment", this.decadeEnvironment);

    	ViewpointOrganizationDao viewpointOrganizationDao = new ViewpointOrganizationDao();
    	model.addAttribute("organization", viewpointOrganizationDao.findByRosid(this.decadeEnvironment));
    	 
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("authenticated", authentication);

    	DecadeSchermDefinitieWerkVanuitDao decadeSchermDefinitieWerkVanuitDao = new DecadeSchermDefinitieWerkVanuitDao();
    	model.addAttribute("schermdefinitieswerkvanuit", decadeSchermDefinitieWerkVanuitDao.findAllSchermDefinitieWerkVanuit(decadeEnvironment, verkortenaam, niveau, type));
    	
        return "schermdefinitieswerkvanuit-index";

    }
    
}