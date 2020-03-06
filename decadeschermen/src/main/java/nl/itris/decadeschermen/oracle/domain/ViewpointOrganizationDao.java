package nl.itris.decadeschermen.oracle.domain;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;

@Component
public class ViewpointOrganizationDao extends DefaultDao {

    public ViewpointOrganization findByRosid(DecadeEnvironment decadeEnvironment) {

    	ViewpointOrganization viewpointOrganization = new ViewpointOrganization();
    	
    	try {
    		
    		Connection connection = getConnection(decadeEnvironment);
    		
    		String SQL = "SELECT ROS_ID, ROS_ORGANIZATION_NAME FROM V_RED_ORGANIZATIONS WHERE ROWNUM = 1";
            
        	ViewpointOrganization viewpointOrganization = this.jdbcTemplateObject.queryForObject(SQL, new ViewpointOrganizationMapper());

    		
    		
    		
    	} catch(SQLException sqlException) {
    		
    	}
    	
    	

    	return viewpointOrganization;
        
    }
    
}