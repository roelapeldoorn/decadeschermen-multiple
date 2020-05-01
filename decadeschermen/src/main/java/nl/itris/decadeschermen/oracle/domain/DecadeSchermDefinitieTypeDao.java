package nl.itris.decadeschermen.oracle.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;

@Component
public class DecadeSchermDefinitieTypeDao extends DefaultDao {

    public DecadeSchermDefinitieType findByVerkortenaamNiveauAndType(DecadeEnvironment decadeEnvironment, String verkortenaam, int niveau, String type) {

    	DecadeSchermDefinitieType decadeSchermDefinitieType = new DecadeSchermDefinitieType();

    	try {
    		
    		String SQL = "SELECT DISTINCT DRSD_DRPR_VERKORTE_NAAM, DRSD_NIVEAU, RRIS_TYPE "
    				+ "FROM DF_RUN_RUBRIEKEN_IN_SCHERM "
    				+ "WHERE DRSD_DRPR_DSSM_CODE = 'DF' "
    				+ "AND DRSD_DRPR_GEBG_CODE = 'AAN' "
    				+ "AND DRSD_DRPR_VERKORTE_NAAM = ? "
    				+ "AND DRSD_NIVEAU = ?" 
    				+ "AND RRIS_TYPE = ?";
    		
    		Connection connection = getConnection(decadeEnvironment);
    		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
    		
    		preparedStatement.setString(1, verkortenaam);
    		preparedStatement.setInt(2, niveau);
    		preparedStatement.setString(3, type);
    		
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		if (rs.next()) {
    			
    			decadeSchermDefinitieType.setVerkortenaam(rs.getString("DRSD_DRPR_VERKORTE_NAAM"));
    			decadeSchermDefinitieType.setNiveau(rs.getInt("DRSD_NIVEAU"));
    			decadeSchermDefinitieType.setType(rs.getString("RRIS_TYPE"));

    		}

   			rs.close();
   			preparedStatement.close();
   			closeConnection(connection);
   			
    	} catch(Exception e) {
    		
    	}

        return decadeSchermDefinitieType;
        
    }

    public List<DecadeSchermDefinitieType> findAllSchermDefinitieTypes(DecadeEnvironment decadeEnvironment, String verkortenaam, int niveau) {
  
    	List<DecadeSchermDefinitieType> listDecadeSchermDefinitieTypes = new ArrayList<DecadeSchermDefinitieType>();
    	
    	try {
    		
        	String SQL = "SELECT DISTINCT DRSD_DRPR_VERKORTE_NAAM, DRSD_NIVEAU, RRIS_TYPE FROM DF_RUN_RUBRIEKEN_IN_SCHERM "
        			   + "WHERE DRSD_DRPR_DSSM_CODE = 'DF' "
        			   + "AND DRSD_DRPR_GEBG_CODE = 'AAN' " 
        			   + "AND DRSD_DRPR_VERKORTE_NAAM = ? " 
        			   + "AND DRSD_NIVEAU = ? " 
        			   + "ORDER BY DRSD_DRPR_VERKORTE_NAAM, DRSD_NIVEAU, RRIS_TYPE";

    		Connection connection = getConnection(decadeEnvironment);

    		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
    		
    		preparedStatement.setString(1, verkortenaam);
    		preparedStatement.setInt(2, niveau);
    		
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		while (rs.next()) {
 
    			DecadeSchermDefinitieType decadeSchermDefinitieType = new DecadeSchermDefinitieType();
    			decadeSchermDefinitieType.setVerkortenaam(rs.getString("DRSD_DRPR_VERKORTE_NAAM"));
    			decadeSchermDefinitieType.setNiveau(rs.getInt("DRSD_NIVEAU"));
    			decadeSchermDefinitieType.setType(rs.getString("RRIS_TYPE"));
    			
    			listDecadeSchermDefinitieTypes.add(decadeSchermDefinitieType);

    		}

   			rs.close();
   			preparedStatement.close();
   			closeConnection(connection);
    		   			
    	} catch(Exception e) {
    		
    	}

    	System.out.println("Voor " + verkortenaam + " en niveau " + niveau + " zijn er " + listDecadeSchermDefinitieTypes.size() + " niveaus.");
    	
    	return listDecadeSchermDefinitieTypes;
    	
    }

}