package nl.itris.decadeschermen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zaxxer.hikari.HikariDataSource;

import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;
import nl.itris.decadeschermen.mysql.repository.EnvironmentRepository;
import nl.itris.decadeschermen.oracle.OracleDbConfig;
import nl.itris.decadeschermen.oracle.repository.ModuleRepository;

@Controller
@RequestMapping("/modules")
public class ModulesController {

	private final EnvironmentRepository environmentRepository;
    private final ModuleRepository moduleRepository;
    
    DecadeEnvironment decadeEnvironment = new DecadeEnvironment();
    
    @Autowired
    public ModulesController(EnvironmentRepository environmentRepository, ModuleRepository moduleRepository) {
    	this.environmentRepository = environmentRepository;
        this.moduleRepository = moduleRepository;
    }
    
    @GetMapping("/{environmentid}")
    public String showModules(@PathVariable("environmentid") long environmentid, Model model) {

    	this.decadeEnvironment = environmentRepository.findById(environmentid)
    			.orElseThrow(() -> new IllegalArgumentException("Omgeving met ID: " + environmentid + " niet gevonden!"));
    	model.addAttribute("environment", this.decadeEnvironment);

    	model.addAttribute("modules", moduleRepository.findAll());
 
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("authenticated", authentication);
           	
        return "module-index";
    	
    }

}