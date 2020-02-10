package nl.itris.decadeschermen.oracle.domain;

import org.springframework.stereotype.Component;

@Component
public class ViewpointOrganizationDao extends DefaultDao {

    public ViewpointOrganization findByRosid() {

    	String SQL = "SELECT ROS_ID, ROS_ORGANIZATION_NAME FROM V_RED_ORGANIZATIONS WHERE ROWNUM = 1";
        
    	ViewpointOrganization viewpointOrganization = this.jdbcTemplateObject.queryForObject(SQL, new ViewpointOrganizationMapper());

        return viewpointOrganization;
        
    }
    
}