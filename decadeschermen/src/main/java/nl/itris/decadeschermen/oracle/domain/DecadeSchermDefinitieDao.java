package nl.itris.decadeschermen.oracle.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;

@Component
public class DecadeSchermDefinitieDao extends DefaultDao {

    public DecadeSchermDefinitie findByVerkortenaam(DecadeEnvironment decadeEnvironment, String stpdverkortenaam) {

    	DecadeSchermDefinitie decadeSchermDefinitie = new DecadeSchermDefinitie();

    	try {
    		
    		String SQL = "SELECT DISTINCT STPD_VERKORTE_NAAM FROM DF_STAND_SCHERM_DEFINITIES WHERE STPD_DSSM_CODE = 'DF' AND STPD_VERKORTE_NAAMN = ?";
    	         
    		Connection connection = getConnection(decadeEnvironment);
    		Statement statement = connection.createStatement();
    		ResultSet rs = statement.executeQuery(SQL);
    		
    		if (rs.next()) {
    			
    			decadeSchermDefinitie.setStpdverkortenaam(rs.getString("STPD_VERKORTE_NAAM"));

    		}

   			rs.close();
   			statement.close();
   			closeConnection(connection);
   			
    	} catch(Exception e) {
    		
    	}

        return decadeSchermDefinitie;
        
    }

    public List<DecadeSchermDefinitie> findAllSchermDefinities(DecadeEnvironment decadeEnvironment, String zoekSchermDefinitie) {
  
    	List<DecadeSchermDefinitie> decadeSchermDefinities = new ArrayList<DecadeSchermDefinitie>();
    	
    	try {
    		
        	String SQL = "SELECT DISTINCT STPD_VERKORTE_NAAM FROM DF_STAND_SCHERM_DEFINITIES WHERE STPD_DSSM_CODE = 'DF'";
        	if (!zoekSchermDefinitie.equals("")) {
        		SQL = SQL + " AND STPD_VERKORTE_NAAM LIKE '" + zoekSchermDefinitie + "%'";
        	} else {
        		SQL = SQL + " AND STPD_VERKORTE_NAAM = 'XXYYZZ'";
        	}
        	SQL = SQL + " ORDER BY STPD_VERKORTE_NAAM";
            
    		Connection connection = getConnection(decadeEnvironment);
    		Statement statement = connection.createStatement();
    		ResultSet rs = statement.executeQuery(SQL);
    		
    		while (rs.next()) {
    			
    			DecadeSchermDefinitie decadeSchermDefinitie = new DecadeSchermDefinitie();
    			decadeSchermDefinitie.setStpdverkortenaam(rs.getString("STPD_VERKORTE_NAAM"));

    			decadeSchermDefinities.add(decadeSchermDefinitie);

    		}

   			rs.close();
   			statement.close();
   			closeConnection(connection);
   			
    	} catch(Exception e) {
    		
    	}

    	return decadeSchermDefinities;
    	
    }

}