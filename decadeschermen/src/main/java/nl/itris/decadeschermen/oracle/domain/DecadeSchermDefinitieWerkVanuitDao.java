	package nl.itris.decadeschermen.oracle.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;

@Component
public class DecadeSchermDefinitieWerkVanuitDao extends DefaultDao {

    public DecadeSchermDefinitieWerkVanuit findByVerkortenaamNiveauTypeAndWerkvanuit(
    		DecadeEnvironment decadeEnvironment, 
    		String verkortenaam, 
    		int niveau, 
    		String type,
    		String werkvanuit) {
    		

    	DecadeSchermDefinitieWerkVanuit decadeSchermDefinitieWerkVanuit = new DecadeSchermDefinitieWerkVanuit();

    	try {
    		
    		String SQL = "SELECT DISTINCT " +
    				"DRSD_DRPR_VERKORTE_NAAM, " +
      				"DRSD_NIVEAU, " +
    				"RRIS_TYPE, " + 
      				"WERKVANUIT FROM (" +
    				"SELECT " +
    				"DRSD_DRPR_VERKORTE_NAAM, " +
    				"DRSD_NIVEAU, " +
    				"RRIS_TYPE, " +
    				"'Runtime' AS WERKVANUIT " + 
    				"FROM DF_RUN_RUBRIEKEN_IN_SCHERM " + 
    				"WHERE DRSD_DRPR_DSSM_CODE = 'DF' " + 
    				"AND DRSD_DRPR_VERKORTE_NAAM = ? " + 
    				"AND DRSD_DRPR_GEBG_CODE = 'AAN' " + 
    				"AND DRSD_NIVEAU = ? " + 
    				"AND RRIS_TYPE = ? " + 
    				"UNION ALL " + 
    				"SELECT " +
    				"ASDF_APDF_VERKORTE_NAAM, " +
    				"ASDF_NIVEAU, " +
    				"ARIS_TYPE, " +
    				"'Aangepast' AS WERKVANUIT " + 
    				"FROM DF_AANGP_RUBRIEKEN_IN_SCHERM " + 
    				"WHERE ASDF_APDF_DSSM_CODE = 'DF' " + 
    				"AND ASDF_APDF_VERKORTE_NAAM = ? " + 
    				"AND ASDF_APDF_GEBG_CODE = 'AAN' " + 
    				"AND ASDF_NIVEAU = ? " + 
    				"AND ARIS_TYPE = ?) " + 
    				"WHERE WERKVANUIT = ?";
    		
    		Connection connection = getConnection(decadeEnvironment);
    		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
    		
    		preparedStatement.setString(1, verkortenaam);
    		preparedStatement.setInt(2, niveau);
    		preparedStatement.setString(3, type);
    		preparedStatement.setString(4, verkortenaam);
    		preparedStatement.setInt(5, niveau);
    		preparedStatement.setString(6, type);

    		preparedStatement.setString(7, werkvanuit);
    		
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		if (rs.next()) {
    			
    			decadeSchermDefinitieWerkVanuit.setVerkortenaam(rs.getString("DRSD_DRPR_VERKORTE_NAAM"));
    			decadeSchermDefinitieWerkVanuit.setNiveau(rs.getInt("DRSD_NIVEAU"));
    			decadeSchermDefinitieWerkVanuit.setType(rs.getString("RRIS_TYPE"));
       			decadeSchermDefinitieWerkVanuit.setWerkVanuit(rs.getString("WERKVANUIT"));

    		}

   			rs.close();
   			preparedStatement.close();
   			closeConnection(connection);
   			
    	} catch(Exception e) {
    		
    	}

    	System.out.println("Scherm " + decadeSchermDefinitieWerkVanuit.getVerkortenaam() + "/" + decadeSchermDefinitieWerkVanuit.getNiveau() + "/" + decadeSchermDefinitieWerkVanuit.getType());
        
    	return decadeSchermDefinitieWerkVanuit;
        
    }

    public List<DecadeSchermDefinitieWerkVanuit> findAllSchermDefinitieWerkVanuit(
    		DecadeEnvironment decadeEnvironment, 
    		String verkortenaam, 
    		int niveau,
    		String type) {
  
    	List<DecadeSchermDefinitieWerkVanuit> listDecadeSchermDefinitieWerkVanuit = new ArrayList<DecadeSchermDefinitieWerkVanuit>();
    	
    	try {
    		
    		String SQL = "SELECT DISTINCT " +
    				"DRSD_DRPR_VERKORTE_NAAM, " +
      				"DRSD_NIVEAU, " +
    				"RRIS_TYPE, " + 
      				"WERKVANUIT FROM (" +
    				"SELECT " +
    				"DRSD_DRPR_VERKORTE_NAAM, " +
    				"DRSD_NIVEAU, " +
    				"RRIS_TYPE, " +
    				"'Runtime' AS WERKVANUIT " + 
    				"FROM DF_RUN_RUBRIEKEN_IN_SCHERM " + 
    				"WHERE DRSD_DRPR_DSSM_CODE = 'DF' " + 
    				"AND DRSD_DRPR_VERKORTE_NAAM = ? " + 
    				"AND DRSD_DRPR_GEBG_CODE = 'AAN' " + 
    				"AND DRSD_NIVEAU = ? " + 
    				"AND RRIS_TYPE = ? " + 
    				"UNION ALL " + 
    				"SELECT " +
    				"ASDF_APDF_VERKORTE_NAAM, " +
    				"ASDF_NIVEAU, " +
    				"ARIS_TYPE, " +
    				"'Aangepast' AS WERKVANUIT " + 
    				"FROM DF_AANGP_RUBRIEKEN_IN_SCHERM " + 
    				"WHERE ASDF_APDF_DSSM_CODE = 'DF' " + 
    				"AND ASDF_APDF_VERKORTE_NAAM = ? " + 
    				"AND ASDF_APDF_GEBG_CODE = 'AAN' " + 
    				"AND ASDF_NIVEAU = ? " + 
    				"AND ARIS_TYPE = ?) " +
    				"ORDER BY DRSD_DRPR_VERKORTE_NAAM, DRSD_NIVEAU, RRIS_TYPE, WERKVANUIT";

    		Connection connection = getConnection(decadeEnvironment);

    		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
    		
    		preparedStatement.setString(1, verkortenaam);
    		preparedStatement.setInt(2, niveau);
    		preparedStatement.setString(3, type);
    		preparedStatement.setString(4, verkortenaam);
    		preparedStatement.setInt(5, niveau);
    		preparedStatement.setString(6, type);
    		
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		while (rs.next()) {
 
    			DecadeSchermDefinitieWerkVanuit decadeSchermDefinitieWerkVanuit = new DecadeSchermDefinitieWerkVanuit();

    			decadeSchermDefinitieWerkVanuit.setVerkortenaam(rs.getString("DRSD_DRPR_VERKORTE_NAAM"));
    			decadeSchermDefinitieWerkVanuit.setNiveau(rs.getInt("DRSD_NIVEAU"));
    			decadeSchermDefinitieWerkVanuit.setType(rs.getString("RRIS_TYPE"));
    			decadeSchermDefinitieWerkVanuit.setWerkVanuit(rs.getString("WERKVANUIT"));
    			
    			listDecadeSchermDefinitieWerkVanuit.add(decadeSchermDefinitieWerkVanuit);

    		}

   			rs.close();
   			preparedStatement.close();
   			closeConnection(connection);
    		   			
    	} catch(Exception e) {
    		
    	}

    	System.out.println("Voor " + verkortenaam + " en niveau " + niveau + " zijn er " + listDecadeSchermDefinitieWerkVanuit.size() + " werken vanuit.");
    	
    	return listDecadeSchermDefinitieWerkVanuit;
    	
    }

}