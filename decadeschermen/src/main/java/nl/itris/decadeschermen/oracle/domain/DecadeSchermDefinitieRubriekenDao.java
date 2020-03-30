package nl.itris.decadeschermen.oracle.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;

@Component
public class DecadeSchermDefinitieRubriekenDao extends DefaultDao {

    public boolean updateByRubriek(
    		DecadeEnvironment decadeEnvironment, 
    		DecadeSchermDefinitieRubrieken decadeSchermDefinitieRubriek) {
    		
    	try {
    		
    		String SQL = "";
    		
    		Connection connection = getConnection(decadeEnvironment);
    		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
    		
    		preparedStatement.setString(1, decadeSchermDefinitieRubriek.getVerkortenaam());
    		preparedStatement.setInt(2, decadeSchermDefinitieRubriek.getNiveau());
    		preparedStatement.setString(3, decadeSchermDefinitieRubriek.getType());
    		
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		if (rs.next()) {
    			
//    			decadeSchermDefinitieRubrieken.setVerkortenaam(rs.getString("DRSD_DRPR_VERKORTE_NAAM"));
//    			decadeSchermDefinitieRubrieken.setNiveau(rs.getInt("DRSD_NIVEAU"));
//    			decadeSchermDefinitieRubrieken.setType(rs.getString("RRIS_TYPE"));

    		}

   			rs.close();
   			preparedStatement.close();
   			closeConnection(connection);
   			
    	} catch(Exception e) {
    		return false;
    	}

        return true;
        
    }

    public List<DecadeSchermDefinitieRubrieken> findAllRubrieken(
    		DecadeEnvironment decadeEnvironment, 
    		String verkortenaam, 
    		int niveau,
    		String type,
    		String werkvanuit) {
    	
    	List<DecadeSchermDefinitieRubrieken> listDecadeSchermDefinitieRubrieken = new ArrayList<DecadeSchermDefinitieRubrieken>();
    	
    	try {
    		

    		Connection connection = getConnection(decadeEnvironment);

    		PreparedStatement preparedStatement = connection.prepareStatement(getSQL());
    		
    		preparedStatement.setString(1, verkortenaam);
    		preparedStatement.setInt(2, niveau);
    		preparedStatement.setString(3, type);
    		
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		while (rs.next()) {
 
    			DecadeSchermDefinitieRubrieken decadeSchermDefinitieRubrieken = new DecadeSchermDefinitieRubrieken();

    			decadeSchermDefinitieRubrieken.setVerkortenaam(rs.getString("ASDF_APDF_VERKORTE_NAAM"));
    			decadeSchermDefinitieRubrieken.setNiveau(rs.getInt("ASDF_NIVEAU"));
    			decadeSchermDefinitieRubrieken.setType(rs.getString("ARIS_TYPE"));
    			
    			decadeSchermDefinitieRubrieken.setTabelnaam(rs.getString("KOLM_TABE_NAAM"));
    			decadeSchermDefinitieRubrieken.setKolomnaam(rs.getString("KOLM_NAAM"));
    			
    			decadeSchermDefinitieRubrieken.setPrompt(rs.getString("PROMPT"));
    			decadeSchermDefinitieRubrieken.setPromptAangepast(rs.getString("PROMPT_AANGP"));
    			
    			decadeSchermDefinitieRubrieken.setVeldVolgnummer(rs.getInt("VELD_VOLGNUMMER"));
    			decadeSchermDefinitieRubrieken.setVeldVolgnummerAangepast(rs.getInt("VELD_VOLGNUMMER_AANGP"));
    			decadeSchermDefinitieRubrieken.setVeldBreedte(rs.getInt("VELD_BREEDTE"));
    			decadeSchermDefinitieRubrieken.setVeldBreedteAangepast(rs.getInt("VELD_BREEDTE_AANGP"));
    			decadeSchermDefinitieRubrieken.setVeldTonen(rs.getInt("IND_VELD_TONEN"));
    			decadeSchermDefinitieRubrieken.setVeldTonenAangepast(rs.getInt("IND_VELD_TONEN_AANGP"));
    			decadeSchermDefinitieRubrieken.setVeldAlleenTonen(rs.getInt("IND_LEEG_VELD_VOLGEN"));
    			decadeSchermDefinitieRubrieken.setVeldAlleenTonenAangepast(rs.getInt("IND_LEEG_VELD_VOLGEN_AANGP"));
    			
    			decadeSchermDefinitieRubrieken.setVerplicht(rs.getInt("IND_VERPLICHT"));
    			decadeSchermDefinitieRubrieken.setVerplichtAangepast(rs.getInt("IND_VERPLICHT_AANGP"));
    			decadeSchermDefinitieRubrieken.setWijzigbaar(rs.getInt("IND_WIJZIGBAAR"));
    			decadeSchermDefinitieRubrieken.setWijzigbaarAangepast(rs.getInt("IND_WIJZIGBAAR_AANGP"));
    			decadeSchermDefinitieRubrieken.setHoofdletters(rs.getInt("IND_HOOFDLETTERS"));
    			decadeSchermDefinitieRubrieken.setHoofdlettersAangepast(rs.getInt("IND_HOOFDLETTERS_AANGP"));
    			decadeSchermDefinitieRubrieken.setHintText(rs.getString("HINT_TEXT"));
    			decadeSchermDefinitieRubrieken.setHintTextAangepast(rs.getString("HINT_TEXT_AANGP"));
    			
    			listDecadeSchermDefinitieRubrieken.add(decadeSchermDefinitieRubrieken);

    		}

   			rs.close();
   			preparedStatement.close();
   			closeConnection(connection);
    		   			
    	} catch(Exception e) {
    		
    	}

    	System.out.println("Voor " + verkortenaam + "/" + niveau + "/" + type + "/ zijn er " +  listDecadeSchermDefinitieRubrieken.size() + " rubrieken.");
    	
    	return listDecadeSchermDefinitieRubrieken;
    	
    }
    
    private String getSQL() {
    	
    	return "SELECT " + 
			"ASDF_APDF_VERKORTE_NAAM, " + 
			"ASDF_NIVEAU, " + 
			"ARIS_TYPE, " + 
			"KOLM_TABE_NAAM, " + 
			"KOLM_NAAM, " + 
			"PROMPT, " + 
			"PROMPT_AANGP, " + 
			"IND_OPVRAAGBAAR, " + 
			"IND_OPVRAAGBAAR_AANGP, " + 
			"IND_VELD_TONEN, " + 
			"IND_VELD_TONEN_AANGP, " + 
			"VELD_VOLGNUMMER, " + 
			"VELD_VOLGNUMMER_AANGP, " + 
			"VELD_BREEDTE, " + 
			"VELD_BREEDTE_AANGP, " + 
			"SORTEER_VOLGORDE, " + 
			"SORTEER_VOLGORDE_AANGP, " + 
			"IND_LEEG_VELD_VOLGEN, " + 
			"IND_LEEG_VELD_VOLGEN_AANGP, " + 
			"IND_VERPLICHT, " + 
			"IND_VERPLICHT_AANGP, " + 
			"IND_HOOFDLETTERS, " + 
			"IND_HOOFDLETTERS_AANGP, " + 
			"IND_VASTE_LENGTE, " + 
			"IND_VASTE_LENGTE_AANGP, " + 
			"IND_WIJZIGBAAR, " + 
			"IND_WIJZIGBAAR_AANGP, " + 
			"IND_DISPLAY_ONLY, " + 
			"IND_DISPLAY_ONLY_AANGP, " + 
			"WIJZE_VAN_TONEN, " + 
			"WIJZE_VAN_TONEN_AANGP, " + 
			"NAAM_POP_LIST, " + 
			"NAAM_POP_LIST_AANGP, " + 
			"NAAM_LOV, " + 
			"NAAM_LOV_AANGP, " + 
			"HINT_TEXT, " + 
			"HINT_TEXT_AANGP, " + 
			"HELPTEKST_DEELSYSTEEM, " + 
			"HELPTEKST_DEELSYSTEEM_AANGP, " + 
			"HELPTEKST_GEBRUIKER, " + 
			"HELPTEKST_GEBRUIKER_AANGP, " + 
			"IND_OPVRAAGBAAR_VERPLICHT, " + 
			"IND_OPVRAAGBAAR_VERPLICHT_AANG, " + 
			"X_POSITIE_VI_SCHERM, " + 
			"X_POSITIE_VI_SCHERM_AANGP, " + 
			"Y_POSITIE_VI_SCHERM, " + 
			"Y_POSITIE_VI_SCHERM_AANGP, " + 
			"PLSQL_CHECK, " + 
			"PLSQL_CHECK_AANGP, " + 
			"SORTEER_SOORT, " + 
			"SORTEER_SOORT_AANGP, " + 
			"VELD_BREEDTE_LOVITEM, " + 
			"VELD_BREEDTE_LOVITEM_AANGP, " + 
			"MAXIMUM_LENGTE, " + 
			"MAXIMUM_LENGTE_AANGP, " + 
			"DESCRIPTOR_FUNCTIE, " + 
			"VASTE_BEPERKING, " + 
			"VASTE_BEPERKING_AANGP " + 
			"FROM DF_AANGP_RUBRIEKEN_IN_SCHERM " + 
			"WHERE ASDF_APDF_DSSM_CODE = 'DF' " + 
			"AND ASDF_APDF_VERKORTE_NAAM = ? " + 
			"AND ASDF_APDF_GEBG_CODE = 'AAN' " + 
			"AND ASDF_NIVEAU = ? " + 
			"AND ARIS_TYPE = ? " + 
			"ORDER BY " + 
			"ASDF_APDF_VERKORTE_NAAM, " + 
			"ASDF_NIVEAU, " + 
			"ARIS_TYPE, " + 
			"VELD_VOLGNUMMER_AANGP, " + 
			"VELD_VOLGNUMMER";

    }
    
}