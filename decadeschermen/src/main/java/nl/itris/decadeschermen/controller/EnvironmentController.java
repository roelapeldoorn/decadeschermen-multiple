package nl.itris.decadeschermen.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.itris.decadeschermen.helper.DatabasetypeList;
import nl.itris.decadeschermen.helper.EnvironmentList;
import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;
import nl.itris.decadeschermen.mysql.repository.EnvironmentRepository;

@Controller
@RequestMapping("/environments")
public class EnvironmentController {

    private final EnvironmentRepository environmentRepository;
    
    @Autowired
    public EnvironmentController(EnvironmentRepository environmentRepository) {
        this.environmentRepository = environmentRepository;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
    	
    	model.addAttribute("environments", environmentRepository.findAll());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("authenticated", authentication);
           	
        return "environment-index";
        
    }

    @GetMapping("signup")
    public String showEnvironmentSignUpForm(Model model) {
    	
    	DecadeEnvironment environment = new DecadeEnvironment();
    	DatabasetypeList databasetypeList = new DatabasetypeList();
    	EnvironmentList environmentList = new EnvironmentList();
    	
    	model.addAttribute("environment", environment);
    	model.addAttribute("databasetypes", databasetypeList.getDatabasetypes());
    	model.addAttribute("otapcodes", environmentList.getOTAPCodes());
    	model.addAttribute("sequences", environmentList.getSequences());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("authenticated", authentication);
    	
        return "environment-add";

    }

    @GetMapping("list")
    public String showEnvironmentListForm(Model model) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("authenticated", authentication);

    	model.addAttribute("environments", environmentRepository.findAll());

    	return "environment-index";
    
    }

    @PostMapping("add")
    public String showEnvironmentAddForm(@Valid DecadeEnvironment environment, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	
        	DatabasetypeList databasetypeList = new DatabasetypeList();
        	EnvironmentList environmentList = new EnvironmentList();
        	
        	model.addAttribute("environment", environment);
        	model.addAttribute("databasetypes", databasetypeList.getDatabasetypes());
        	model.addAttribute("otapcodes", environmentList.getOTAPCodes());
        	model.addAttribute("sequences", environmentList.getSequences());

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        	model.addAttribute("authenticated", authentication);

            return "environment-add";

        }

        environmentRepository.save(environment);
        
        return "redirect:list";
        
    }

    @GetMapping("edit/{environmentid}")
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

    @PostMapping("update/{environmentid}")
    public String updateEnvironment(@PathVariable("environmentid") long environmentid, @Valid DecadeEnvironment environment, BindingResult result, Model model) {
    	
        if (result.hasErrors()) {
        	environment.setEnvironmentid(environmentid);
        	
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

        environmentRepository.save(environment);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("authenticated", authentication);

        model.addAttribute("environments", environmentRepository.findAll());
        
        return "environment-index";
        
    }

    @GetMapping("delete/{environmentid}")
    public String deleteEnvironment(@PathVariable("environmentid") long environmentid, Model model) {
    	DecadeEnvironment environment = environmentRepository.findById(environmentid)
            .orElseThrow(() -> new IllegalArgumentException("Omgeving met ID: " + environmentid + " niet gevonden!"));
    	
    	environmentRepository.delete(environment);
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("authenticated", authentication);

    	model.addAttribute("environments", environmentRepository.findAll());
    	
        return "environment-index";
        
    }    
   
}