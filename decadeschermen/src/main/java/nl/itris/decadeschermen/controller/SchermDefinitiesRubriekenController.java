package nl.itris.decadeschermen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import nl.itris.decadeschermen.helper.DatabasetypeList;
import nl.itris.decadeschermen.helper.EnvironmentList;
import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;
import nl.itris.decadeschermen.mysql.repository.EnvironmentRepository;
import nl.itris.decadeschermen.oracle.domain.DecadeSchermDefinitieDao;
import nl.itris.decadeschermen.oracle.domain.DecadeSchermDefinitieNiveauDao;
import nl.itris.decadeschermen.oracle.domain.DecadeSchermDefinitieRubrieken;
import nl.itris.decadeschermen.oracle.domain.DecadeSchermDefinitieRubriekenDao;
import nl.itris.decadeschermen.oracle.domain.DecadeSchermDefinitieTypeDao;
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

    
    @GetMapping("/environmentid/{environmentid}/verkortenaam/{verkortenaam}/niveau/{niveau}/type/{type}")
    public String showSchermDefinitiesRubrieken(
    		@PathVariable("environmentid") long environmentid, 
    		@PathVariable("verkortenaam") String verkortenaam, 
    		@PathVariable("niveau") int niveau, 
    		@PathVariable("type") String type, 
    		Model model) {

    	this.decadeEnvironment = environmentRepository.findById(environmentid).orElseThrow(() -> new IllegalArgumentException("Omgeving met ID: " + environmentid + " niet gevonden!"));
    	model.addAttribute("environment", this.decadeEnvironment);

    	ViewpointOrganizationDao viewpointOrganizationDao = new ViewpointOrganizationDao();
    	model.addAttribute("organization", viewpointOrganizationDao.findByRosid(this.decadeEnvironment));
    	 
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("authenticated", authentication);

    	DecadeSchermDefinitieTypeDao decadeSchermDefinitieTypeDao = new DecadeSchermDefinitieTypeDao();
    	model.addAttribute("schermdefinitietype", decadeSchermDefinitieTypeDao.findByVerkortenaamNiveauAndType(decadeEnvironment, verkortenaam, niveau, type));

    	DecadeSchermDefinitieRubriekenDao decadeSchermDefinitieRubriekeDao = new DecadeSchermDefinitieRubriekenDao();
    	model.addAttribute("schermdefinitiesrubrieken", decadeSchermDefinitieRubriekeDao.findAllRubrieken(
    			this.decadeEnvironment, 
    			verkortenaam, 
    			niveau, 
    			type));
    	
        return "schermdefinitiesrubrieken-index";

    }

    @GetMapping("/edit/environmentid/{environmentid}/verkortenaam/{verkortenaam}/niveau/{niveau}/type/{type}/tabelnaam/{tabelNaam}/kolomnaam/{tabelKolomnaam}")
    public String showSchermDefinitiesRubriekenUpdateForm(
    		@PathVariable("environmentid") long environmentid, 
    		@PathVariable("verkortenaam") String verkortenaam, 
    		@PathVariable("niveau") int niveau, 
    		@PathVariable("type") String type, 
    		@PathVariable("tabelNaam") String tabelNaam, 
    		@PathVariable("tabelKolomnaam") String tabelKolomnaam,
    		Model model) {

    	System.out.println("Wijzig rubriek: " + tabelNaam + "/" + tabelKolomnaam);
	
		this.decadeEnvironment = environmentRepository.findById(environmentid).orElseThrow(() -> new IllegalArgumentException("Omgeving met ID: " + environmentid + " niet gevonden!"));
		model.addAttribute("environment", this.decadeEnvironment);

		ViewpointOrganizationDao viewpointOrganizationDao = new ViewpointOrganizationDao();
		model.addAttribute("organization", viewpointOrganizationDao.findByRosid(this.decadeEnvironment));
	 
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("authenticated", authentication);

		DecadeSchermDefinitieRubriekenDao decadeSchermDefinitieRubriekeDao = new DecadeSchermDefinitieRubriekenDao();
		
		DecadeSchermDefinitieRubrieken decadeSchermDefinitieRubriek = new DecadeSchermDefinitieRubrieken();
		decadeSchermDefinitieRubriek.setVerkortenaam(verkortenaam);
		decadeSchermDefinitieRubriek.setNiveau(niveau);
		decadeSchermDefinitieRubriek.setType(type);
		decadeSchermDefinitieRubriek.setTabelNaam(tabelNaam);
		decadeSchermDefinitieRubriek.setTabelKolomnaam(tabelKolomnaam);
		
		model.addAttribute("schermdefinitiesrubriek", decadeSchermDefinitieRubriekeDao.findRubriek(
			this.decadeEnvironment, decadeSchermDefinitieRubriek));
	
    	return "schermdefinitiesrubrieken-update";
    }
    
    public String showEnvironmentUpdateForm(@PathVariable("environmentid") long environmentid, Model model) {
    	DecadeEnvironment environment = environmentRepository.findById(environmentid)
            .orElseThrow(() -> new IllegalArgumentException("Omgeving met ID: " + environmentid + " niet gevonden!"));

    	DatabasetypeList databasetypeList = new DatabasetypeList();
    	EnvironmentList environmentList = new EnvironmentList();
    	
    	model.addAttribute("environment", environment);
    	model.addAttribute("databasetypes", databasetypeList.getDatabasetypes());
    	model.addAttribute("otapcodes", environmentList.getOTAPCodes());
    	model.addAttribute("sequences", environmentList.getSequences());
    	
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("authenticated", authentication);

    	return "environment-update";
        
    }
    
}