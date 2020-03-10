package nl.itris.decadeschermen.oracle.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;

@Component
public class ViewpointOrganizationDao extends DefaultDao {

    public ViewpointOrganization findByRosid(DecadeEnvironment decadeEnvironment) {

    	ViewpointOrganization viewpointOrganization = new ViewpointOrganization();
    	
    	try {
    		
    		String SQL = "SELECT ROS_ID, ROS_ORGANIZATION_NAME FROM V_RED_ORGANIZATIONS WHERE ROWNUM = 1";
            
    		Connection connection = getConnection(decadeEnvironment);
    		Statement statement = connection.createStatement();
    		ResultSet rs = statement.executeQuery(SQL);
    		
    		if (rs.next()) {
    			
    			viewpointOrganization.setRosid(rs.getLong("ROS_ID"));
    			viewpointOrganization.setRosorganisationname(rs.getString("ROS_ORGANIZATION_NAME"));

    		}

   			rs.close();
   			statement.close();
   			closeConnection(connection);
   			
    	} catch(Exception e) {
    		
    	}

    	return viewpointOrganization;
        
    }
    
}