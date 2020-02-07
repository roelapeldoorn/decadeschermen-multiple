package nl.itris.decadeschermen.oracle.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

class DecadeModuleMapper implements RowMapper<DecadeModule> {

	public DecadeModule mapRow(ResultSet rs, int rowNum) throws SQLException {
		
    	DecadeModule decadeModule = new DecadeModule();
    	
    	decadeModule.setRonid(rs.getLong("RON_ID"));
    	decadeModule.setRonoption(rs.getString("RON_OPTION"));
    	decadeModule.setRonallowed(rs.getString("RON_ALLOWED"));
    	decadeModule.setRondescription(rs.getString("RON_DESCRIPTION"));

        return decadeModule;

	}

}