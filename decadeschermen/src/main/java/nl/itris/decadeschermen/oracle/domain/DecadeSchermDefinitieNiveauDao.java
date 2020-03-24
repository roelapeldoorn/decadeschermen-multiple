package nl.itris.decadeschermen.oracle.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;

@Component
public class DecadeSchermDefinitieNiveauDao extends DefaultDao {

    public DecadeSchermDefinitieNiveau findByVerkortenaamAndNiveau(DecadeEnvironment decadeEnvironment, String verkortenaam, int niveau) {

    	DecadeSchermDefinitieNiveau decadeSchermDefinitieNiveau = new DecadeSchermDefinitieNiveau();

    	try {
    		
    		String SQL = "SELECT DISTINCT DRPR_VERKORTE_NAAM, DRSD_NIVEAU "
    				+ "FROM DF_RUN_SCHERM_DEFINITIES "
    				+ "WHERE DRPR_DSSM_CODE = 'DF' "
    				+ "AND DRSD_DRPR_GEBG_CODE = 'AAN' "
    				+ "AND DRPR_VERKORTE_NAAM = ? "
    				+ "AND DRSD_NIVEAU = ?";
    	         
    		Connection connection = getConnection(decadeEnvironment);
    		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
    		
    		preparedStatement.setString(1, verkortenaam);
    		preparedStatement.setInt(2, niveau);
    		
    		ResultSet rs = preparedStatement.executeQuery(SQL);
    		
    		if (rs.next()) {
    			
    			decadeSchermDefinitieNiveau.setVerkortenaam(rs.getString("DRPR_VERKORTE_NAAM"));
    			decadeSchermDefinitieNiveau.setNiveau(rs.getInt("DRSD_NIVEAU"));

    		}

   			rs.close();
   			preparedStatement.close();
   			closeConnection(connection);
   			
    	} catch(Exception e) {
    		
    	}

        return decadeSchermDefinitieNiveau;
        
    }

    public List<DecadeSchermDefinitieNiveau> findAllSchermDefinitieNiveaus(DecadeEnvironment decadeEnvironment, String verkortenaam) {
  
    	List<DecadeSchermDefinitieNiveau> listDecadeSchermDefinitieNiveaus = new ArrayList<DecadeSchermDefinitieNiveau>();
    	
    	try {
    		
        	String SQL = "SELECT DISTINCT DRPR_VERKORTE_NAAM, DRSD_NIVEAU FROM DF_RUN_SCHERM_DEFINITIES "
        			   + "WHERE DRPR_DSSM_CODE = 'DF' "
        			   + "AND DRSD_DRPR_GEBG_CODE = 'AAN' " 
        			   + "AND DRPR_VERKORTE_NAAM = ? " 
        			   + "ORDER BY DRPR_VERKORTE_NAAM, DRSD_NIVEAU";
        			   
    		Connection connection = getConnection(decadeEnvironment);

    		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
    		
    		preparedStatement.setString(1, verkortenaam);
    		
    		ResultSet rs = preparedStatement.executeQuery(SQL);
    		
    		if (rs.next()) {
 
    		   	DecadeSchermDefinitieNiveau decadeSchermDefinitieNiveau = new DecadeSchermDefinitieNiveau();
    			decadeSchermDefinitieNiveau.setVerkortenaam(rs.getString("DRPR_VERKORTE_NAAM"));
    			decadeSchermDefinitieNiveau.setNiveau(rs.getInt("DRSD_NIVEAU"));
    			
    			listDecadeSchermDefinitieNiveaus.add(decadeSchermDefinitieNiveau);

    		}

   			rs.close();
   			preparedStatement.close();
   			closeConnection(connection);
    		   			
    	} catch(Exception e) {
    		
    	}

    	return listDecadeSchermDefinitieNiveaus;
    	
    }

}