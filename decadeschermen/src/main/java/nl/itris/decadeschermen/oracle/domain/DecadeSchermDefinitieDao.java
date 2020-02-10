package nl.itris.decadeschermen.oracle.domain;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DecadeSchermDefinitieDao {

	private JdbcTemplate jdbcTemplateObject;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplateObject) {
		
	    this.jdbcTemplateObject = jdbcTemplateObject;  
	
	}  
	
    public DecadeSchermDefinitie findByVerkortenaam(String stpdverkortenaam) {

    	String SQL = "SELECT DISTINCT STPD_VERKORTE_NAAM FROM DF_STAND_SCHERM_DEFINITIES WHERE STPD_DSSM_CODE = 'DF' AND STPD_VERKORTE_NAAMN = ?";
        
    	DecadeSchermDefinitie decadeSchermDefinities = this.jdbcTemplateObject.queryForObject(SQL, new Object[]{stpdverkortenaam}, new DecadeSchermDefinitieMapper());

        return decadeSchermDefinities;
        
    }

    public List<DecadeSchermDefinitie> findAllSchermDefinities(String zoekSchermDefinitie) {
    
    	String SQL = "SELECT DISTINCT STPD_VERKORTE_NAAM FROM DF_STAND_SCHERM_DEFINITIES WHERE STPD_DSSM_CODE = 'DF'";
    	if (!zoekSchermDefinitie.equals("")) {
    		SQL = SQL + " AND STPD_VERKORTE_NAAM LIKE '" + zoekSchermDefinitie + "%";
    	}
    	SQL = SQL + " ORDER BY STPD_VERKORTE_NAAM";
    	
    	List<DecadeSchermDefinitie> decadeSchermDefinities = this.jdbcTemplateObject.query(SQL, new DecadeSchermDefinitieMapper());
    	
        return decadeSchermDefinities;
    	
    }

    
}