package nl.itris.decadeschermen.oracle.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;

@Component
public class DecadeModuleDao extends DefaultDao {

	
    public DecadeModule findByRonoption(DecadeEnvironment decadeEnvironment, String ronoption) {
    	
    	DecadeModule decadeModule = new DecadeModule();

    	try {
    		
    		String SQL = "SELECT RON_ID, RON_OPTION, RON_ALLOWED, RON_DESCRIPTION FROM RED_OPTIONS WHERE RON_OPTION = ?";
                 
    		Connection connection = getConnection(decadeEnvironment);
    		Statement statement = connection.createStatement();
    		ResultSet rs = statement.executeQuery(SQL);
    		
    		if (rs.next()) {
    			
    	    	decadeModule.setRonid(rs.getLong("RON_ID"));
    	    	decadeModule.setRonoption(rs.getString("RON_OPTION"));
    	    	decadeModule.setRonallowed(rs.getString("RON_ALLOWED"));
    	    	decadeModule.setRondescription(rs.getString("RON_DESCRIPTION"));

    		}

   			rs.close();
   			statement.close();
   			closeConnection(connection);
   			
    	} catch(Exception e) {
    		
    	}

    	return decadeModule;
    	 
    }

    public List<DecadeModule> findAllRonoptions(DecadeEnvironment decadeEnvironment) {
    
    	List<DecadeModule> decadeModules = new ArrayList<DecadeModule>();
    	
    	try {
    		
    		String SQL = "SELECT RON_ID, RON_OPTION, RON_ALLOWED, RON_DESCRIPTION FROM RED_OPTIONS ORDER BY RON_OPTION";
        	 
    		Connection connection = getConnection(decadeEnvironment);
    		Statement statement = connection.createStatement();
    		ResultSet rs = statement.executeQuery(SQL);
    		
    		while (rs.next()) {
    			
    			DecadeModule decadeModule = new DecadeModule();
    	    	decadeModule.setRonid(rs.getLong("RON_ID"));
    	    	decadeModule.setRonoption(rs.getString("RON_OPTION"));
    	    	decadeModule.setRonallowed(rs.getString("RON_ALLOWED"));
    	    	decadeModule.setRondescription(rs.getString("RON_DESCRIPTION"));

    	    	decadeModules.add(decadeModule);
    	    	
    		}

   			rs.close();
   			statement.close();
   			closeConnection(connection);
   			
    	} catch(Exception e) {
    		
    	}

    	return decadeModules;
    	
    }

    
}