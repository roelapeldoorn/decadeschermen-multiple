package nl.itris.decadeschermen.oracle.domain;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DecadeModuleDao {

	private JdbcTemplate jdbcTemplateObject;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplateObject) {
		
	    this.jdbcTemplateObject = jdbcTemplateObject;  
	
	}  
	
    public DecadeModule findByRonoption(String ronoption) {

    	String SQL = "SELECT RON_ID, RON_OPTION, RON_ALLOWED, RON_DESCRIPTION FROM RED_OPTIONS WHERE RON_OPTION = ?";
        
    	DecadeModule decadeModule = this.jdbcTemplateObject.queryForObject(SQL, new Object[]{ronoption}, new DecadeModuleMapper());

        return decadeModule;
        
    }

    public List<DecadeModule> findAllRonoptions() {
    
    	String SQL = "SELECT RON_ID, RON_OPTION, RON_ALLOWED, RON_DESCRIPTION FROM RED_OPTIONS ORDER BY RON_OPTION";
    	
    	List<DecadeModule> decadeModules = this.jdbcTemplateObject.query(SQL, new DecadeModuleMapper());
    	
        return decadeModules;
    	
    }

    
}