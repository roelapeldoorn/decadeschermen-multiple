package nl.itris.decadeschermen.oracle.domain;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ViewpointOrganizationDao {

	private JdbcTemplate jdbcTemplateObject;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplateObject) {
		
	    this.jdbcTemplateObject = jdbcTemplateObject;  
	
	}  
	
    public ViewpointOrganization findByRosid() {

    	String SQL = "SELECT ROS_ID, ROS_ORGANIZATION_NAME FROM V_RED_ORGANIZATIONS WHERE ROWNUM = 1";
        
    	ViewpointOrganization viewpointOrganization = this.jdbcTemplateObject.queryForObject(SQL, new ViewpointOrganizationMapper());

        return viewpointOrganization;
        
    }
    
}