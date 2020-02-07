package nl.itris.decadeschermen.oracle.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

class ViewpointOrganizationMapper implements RowMapper<ViewpointOrganization> {

	public ViewpointOrganization mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ViewpointOrganization viewpointOrganization = new ViewpointOrganization();
    	
		viewpointOrganization.setRosid(rs.getLong("ROS_ID"));
		viewpointOrganization.setRosorganisationname(rs.getString("ROS_ORGANIZATION_NAME"));

        return viewpointOrganization;

	}

}