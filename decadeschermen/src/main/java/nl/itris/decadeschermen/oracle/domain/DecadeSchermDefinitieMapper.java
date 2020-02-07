package nl.itris.decadeschermen.oracle.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

class DecadeSchermDefinitieMapper implements RowMapper<DecadeSchermDefinitie> {

	public DecadeSchermDefinitie mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DecadeSchermDefinitie decadeSchermDefinities = new DecadeSchermDefinitie();
    	
    	decadeSchermDefinities.setStpdverkortenaam(rs.getString("STPD_VERKORTE_NAAM"));
    	
        return decadeSchermDefinities;

	}

}