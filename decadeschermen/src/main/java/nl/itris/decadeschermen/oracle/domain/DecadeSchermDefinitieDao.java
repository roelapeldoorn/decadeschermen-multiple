package nl.itris.decadeschermen.oracle.domain;

import java.util.List;
import org.springframework.stereotype.Component;

import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;

@Component
public class DecadeSchermDefinitieDao extends DefaultDao {

    public DecadeSchermDefinitie findByVerkortenaam(DecadeEnvironment decadeEnvironment, String stpdverkortenaam) {

    	String SQL = "SELECT DISTINCT STPD_VERKORTE_NAAM FROM DF_STAND_SCHERM_DEFINITIES WHERE STPD_DSSM_CODE = 'DF' AND STPD_VERKORTE_NAAMN = ?";
        
    	DecadeSchermDefinitie decadeSchermDefinities = this.jdbcTemplateObject.queryForObject(SQL, new Object[]{stpdverkortenaam}, new DecadeSchermDefinitieMapper());

        return decadeSchermDefinities;
        
    }

    public List<DecadeSchermDefinitie> findAllSchermDefinities(DecadeEnvironment decadeEnvironment, String zoekSchermDefinitie) {
  
    	
    	
    	String SQL = "SELECT DISTINCT STPD_VERKORTE_NAAM FROM DF_STAND_SCHERM_DEFINITIES WHERE STPD_DSSM_CODE = 'DF'";
    	if (!zoekSchermDefinitie.equals("")) {
    		SQL = SQL + " AND STPD_VERKORTE_NAAM LIKE '" + zoekSchermDefinitie + "%'";
    	} else {
    		SQL = SQL + " AND STPD_VERKORTE_NAAM = 'XXYYZZ'";
    	}
    	SQL = SQL + " ORDER BY STPD_VERKORTE_NAAM";
    	
    	List<DecadeSchermDefinitie> decadeSchermDefinities = this.jdbcTemplateObject.query(SQL, new DecadeSchermDefinitieMapper());
    	
        return decadeSchermDefinities;
    	
    }

}