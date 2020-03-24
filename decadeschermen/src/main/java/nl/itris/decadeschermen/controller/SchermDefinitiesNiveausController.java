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
import nl.itris.decadeschermen.oracle.domain.DecadeSchermDefinitie;
import nl.itris.decadeschermen.oracle.domain.DecadeSchermDefinitieDao;
import nl.itris.decadeschermen.oracle.domain.DecadeSchermDefinitieNiveauDao;
import nl.itris.decadeschermen.oracle.domain.ViewpointOrganizationDao;

@Controller
@RequestMapping("/schermdefinitiesniveaus")
public class SchermDefinitiesNiveausController {

	private final EnvironmentRepository environmentRepository;
	
	private DecadeSchermDefinitie decadeSchermDefinitie;
	private int niveau;
    
    DecadeEnvironment decadeEnvironment = new DecadeEnvironment();
    
    @Autowired
    public SchermDefinitiesNiveausController(EnvironmentRepository environmentRepository) {
    	this.environmentRepository = environmentRepository;
    	this.niveau = 0;
    }

    
    @GetMapping("/environmentid/{environmentid}/verkortenaam/{verkortenaam}")
    public String showSchermDefinitiesNiveaus(
    		@PathVariable("environmentid") long environmentid, 
    		@PathVariable("verkortenaam") String verkortenaam, 
    		Model model) {
 
    	ViewpointOrganizationDao viewpointOrganizationDao = new ViewpointOrganizationDao();
    	model.addAttribute("organization", viewpointOrganizationDao.findByRosid(this.decadeEnvironment));
    	 
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("authenticated", authentication);

    	this.decadeEnvironment = environmentRepository.findById(environmentid).orElseThrow(() -> new IllegalArgumentException("Omgeving met ID: " + environmentid + " niet gevonden!"));
    	model.addAttribute("environment", this.decadeEnvironment);

    	DecadeSchermDefinitieDao decadeSchermDefinitieDao = new DecadeSchermDefinitieDao();
    	model.addAttribute("schermdefinitie", decadeSchermDefinitieDao.findByVerkortenaam(this.decadeEnvironment, verkortenaam));
    	
    	DecadeSchermDefinitieNiveauDao decadeSchermDefinitieNiveauDao = new DecadeSchermDefinitieNiveauDao();
    	model.addAttribute("schermdefinitiesniveaus", decadeSchermDefinitieNiveauDao.findAllSchermDefinitieNiveaus(this.decadeEnvironment, verkortenaam));
    	
        return "schermdefinitiesniveaus-index";

    }
    
//    @RequestMapping(value = "/{environmentid},{verkortenaam}/", method = RequestMethod.GET)
//    public String showSchermDefinities(@PathVariable("environmentid") long environmentid, @PathVariable("verkortenaam") String verkortenaam, Model model) {
//
//    	ViewpointOrganizationDao viewpointOrganizationDao = new ViewpointOrganizationDao();
//    	model.addAttribute("organization", viewpointOrganizationDao.findByRosid(this.decadeEnvironment));
//    	 
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    	model.addAttribute("authenticated", authentication);
//
//    	this.decadeEnvironment = environmentRepository.findById(environmentid).orElseThrow(() -> new IllegalArgumentException("Omgeving met ID: " + environmentid + " niet gevonden!"));
//    	model.addAttribute("environment", this.decadeEnvironment);
//
//    	DecadeSchermDefinitieDao decadeSchermDefinitieDao = new DecadeSchermDefinitieDao();
//    	model.addAttribute("schermdefinitie", decadeSchermDefinitieDao.findByVerkortenaam(this.decadeEnvironment, verkortenaam));
//    	
//    	DecadeSchermDefinitieNiveauDao decadeSchermDefinitieNiveauDao = new DecadeSchermDefinitieNiveauDao();
//    	model.addAttribute("schermdefinitiesniveaus", decadeSchermDefinitieNiveauDao.findAllSchermDefinitieNiveaus(this.decadeEnvironment, verkortenaam));
//    	
//        return "schermdefinitiesniveaus-index";
//    	
//    }
    
    
}