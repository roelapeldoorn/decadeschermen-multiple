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

    public DecadeSchermDefinitieRubrieken findRubriek(
    		DecadeEnvironment decadeEnvironment, 
    		DecadeSchermDefinitieRubrieken decadeSchermDefinitieRubriek) {
    		
    	try {
    		
    		String SQL = "";
    		
    		Connection connection = getConnection(decadeEnvironment);
    		PreparedStatement preparedStatement = connection.prepareStatement(getSQLRubriek());
    		
    		preparedStatement.setString(1, decadeSchermDefinitieRubriek.getVerkortenaam());
    		preparedStatement.setInt(2, decadeSchermDefinitieRubriek.getNiveau());
    		preparedStatement.setString(3, decadeSchermDefinitieRubriek.getType());
    		preparedStatement.setString(4, decadeSchermDefinitieRubriek.getTabelNaam());
    		preparedStatement.setString(5, decadeSchermDefinitieRubriek.getTabelKolomnaam());
    		
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		if (rs.next()) {
    			
    			decadeSchermDefinitieRubriek.setVerkortenaam(rs.getString("DRSD_DRPR_VERKORTE_NAAM"));
    			decadeSchermDefinitieRubriek.setNiveau(rs.getInt("DRSD_NIVEAU"));
    			decadeSchermDefinitieRubriek.setType(rs.getString("RRIS_TYPE"));
    			decadeSchermDefinitieRubriek.setTabelNaam(rs.getString("KOLM_TABE_NAAM"));
    			decadeSchermDefinitieRubriek.setTabelKolomnaam(rs.getString("KOLM_NAAM"));
    			decadeSchermDefinitieRubriek.setTabelDssmCode(rs.getString("KOLM_TABE_DSSM_CODE"));
    			
    			decadeSchermDefinitieRubriek.setPrompt(rs.getString("PROMPT"));
    			decadeSchermDefinitieRubriek.setIndicatieOpvraagbaar(rs.getInt("IND_OPVRAAGBAAR"));
    			decadeSchermDefinitieRubriek.setIndicatieVeldTonen(rs.getInt("IND_VELD_TONEN"));
    			decadeSchermDefinitieRubriek.setVeldVolgnummer(rs.getInt("VELD_VOLGNUMMER"));
    			decadeSchermDefinitieRubriek.setVeldBreedte(rs.getInt("VELD_BREEDTE"));
    			decadeSchermDefinitieRubriek.setSorteerVolgorde(rs.getInt("SORTEER_VOLGORDE"));
    			decadeSchermDefinitieRubriek.setIndicatieLeegVeldVolgen(rs.getInt("IND_LEEG_VELD_VOLGEN"));
    			decadeSchermDefinitieRubriek.setIndicatieVerplicht(rs.getInt("IND_VERPLICHT"));
    			decadeSchermDefinitieRubriek.setIndicatieHoofdletters(rs.getInt("IND_HOOFDLETTERS"));
    			decadeSchermDefinitieRubriek.setIndicatieVasteLengte(rs.getInt("IND_VASTE_LENGTE"));
    			decadeSchermDefinitieRubriek.setIndicatieWijzigbaar(rs.getInt("IND_WIJZIGBAAR"));
    			decadeSchermDefinitieRubriek.setIndicatieDisplayOnly(rs.getInt("IND_DISPLAY_ONLY"));
    			decadeSchermDefinitieRubriek.setWijzeVanTonen(rs.getString("WIJZE_VAN_TONEN"));
    			decadeSchermDefinitieRubriek.setNaamPopList(rs.getString("NAAM_POP_LIST"));
    			decadeSchermDefinitieRubriek.setNaamLov(rs.getString("NAAM_LOV"));
    			decadeSchermDefinitieRubriek.setHintText(rs.getString("HINT_TEXT"));
    			decadeSchermDefinitieRubriek.setHelptekstDeelsysteem(rs.getString("HELPTEKST_DEELSYSTEEM"));
    			decadeSchermDefinitieRubriek.setHelptekstGebruiker(rs.getString("HELPTEKST_GEBRUIKER"));
    			decadeSchermDefinitieRubriek.setIndicatieOpvraagbaarVerplicht(rs.getInt("IND_OPVRAAGBAAR_VERPLICHT"));
    			decadeSchermDefinitieRubriek.setXPositieVIScherm(rs.getInt("X_POSITIE_VI_SCHERM"));
    			decadeSchermDefinitieRubriek.setYPositieVIScherm(rs.getInt("Y_POSITIE_VI_SCHERM"));
    			decadeSchermDefinitieRubriek.setPlsqlCheck(rs.getString("PLSQL_CHECK"));
    			decadeSchermDefinitieRubriek.setSorteerSoort(rs.getString("SORTEER_SOORT"));
    			decadeSchermDefinitieRubriek.setVeldBreedteLovItem(rs.getInt("VELD_BREEDTE_LOVITEM"));
    			decadeSchermDefinitieRubriek.setMaximumLengte(rs.getInt("MAXIMUM_LENGTE"));
    			decadeSchermDefinitieRubriek.setDescriptorFunctie(rs.getString("DESCRIPTOR_FUNCTIE"));
    			decadeSchermDefinitieRubriek.setVasteBeperking(rs.getString("VASTE_BEPERKING"));
    			
    		}

   			rs.close();
   			preparedStatement.close();
   			closeConnection(connection);
   			
    	} catch(Exception e) {
    		return null;
    	}

        return decadeSchermDefinitieRubriek;
        
    }

    public List<DecadeSchermDefinitieRubrieken> findAllRubrieken(
    		DecadeEnvironment decadeEnvironment, 
    		String verkortenaam, 
    		int niveau,
    		String type) {
    	
    	List<DecadeSchermDefinitieRubrieken> listDecadeSchermDefinitieRubrieken = new ArrayList<DecadeSchermDefinitieRubrieken>();

    	try {

    		Connection connection = getConnection(decadeEnvironment);

    		PreparedStatement preparedStatement = connection.prepareStatement(getSQLAllRubrieken());
    		
    		preparedStatement.setString(1, verkortenaam);
    		preparedStatement.setInt(2, niveau);
    		preparedStatement.setString(3, type);
    		
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		while (rs.next()) {
 
    			DecadeSchermDefinitieRubrieken decadeSchermDefinitieRubrieken = new DecadeSchermDefinitieRubrieken();

    			decadeSchermDefinitieRubrieken.setVerkortenaam(rs.getString("DRSD_DRPR_VERKORTE_NAAM"));
    			decadeSchermDefinitieRubrieken.setNiveau(rs.getInt("DRSD_NIVEAU"));
    			decadeSchermDefinitieRubrieken.setType(rs.getString("RRIS_TYPE"));
    			decadeSchermDefinitieRubrieken.setTabelNaam(rs.getString("KOLM_TABE_NAAM"));
    			decadeSchermDefinitieRubrieken.setTabelKolomnaam(rs.getString("KOLM_NAAM"));
    			decadeSchermDefinitieRubrieken.setTabelDssmCode(rs.getString("KOLM_TABE_DSSM_CODE"));
    			
    			decadeSchermDefinitieRubrieken.setPrompt(rs.getString("PROMPT"));
    			decadeSchermDefinitieRubrieken.setIndicatieOpvraagbaar(rs.getInt("IND_OPVRAAGBAAR"));
    			decadeSchermDefinitieRubrieken.setIndicatieVeldTonen(rs.getInt("IND_VELD_TONEN"));
    			decadeSchermDefinitieRubrieken.setVeldVolgnummer(rs.getInt("VELD_VOLGNUMMER"));
    			decadeSchermDefinitieRubrieken.setVeldBreedte(rs.getInt("VELD_BREEDTE"));
    			decadeSchermDefinitieRubrieken.setSorteerVolgorde(rs.getInt("SORTEER_VOLGORDE"));
    			decadeSchermDefinitieRubrieken.setIndicatieLeegVeldVolgen(rs.getInt("IND_LEEG_VELD_VOLGEN"));
    			decadeSchermDefinitieRubrieken.setIndicatieVerplicht(rs.getInt("IND_VERPLICHT"));
    			decadeSchermDefinitieRubrieken.setIndicatieHoofdletters(rs.getInt("IND_HOOFDLETTERS"));
    			decadeSchermDefinitieRubrieken.setIndicatieVasteLengte(rs.getInt("IND_VASTE_LENGTE"));
    			decadeSchermDefinitieRubrieken.setIndicatieWijzigbaar(rs.getInt("IND_WIJZIGBAAR"));
    			decadeSchermDefinitieRubrieken.setIndicatieDisplayOnly(rs.getInt("IND_DISPLAY_ONLY"));
    			decadeSchermDefinitieRubrieken.setWijzeVanTonen(rs.getString("WIJZE_VAN_TONEN"));
    			decadeSchermDefinitieRubrieken.setNaamPopList(rs.getString("NAAM_POP_LIST"));
    			decadeSchermDefinitieRubrieken.setNaamLov(rs.getString("NAAM_LOV"));
    			decadeSchermDefinitieRubrieken.setHintText(rs.getString("HINT_TEXT"));
    			decadeSchermDefinitieRubrieken.setHelptekstDeelsysteem(rs.getString("HELPTEKST_DEELSYSTEEM"));
    			decadeSchermDefinitieRubrieken.setHelptekstGebruiker(rs.getString("HELPTEKST_GEBRUIKER"));
    			decadeSchermDefinitieRubrieken.setIndicatieOpvraagbaarVerplicht(rs.getInt("IND_OPVRAAGBAAR_VERPLICHT"));
    			decadeSchermDefinitieRubrieken.setXPositieVIScherm(rs.getInt("X_POSITIE_VI_SCHERM"));
    			decadeSchermDefinitieRubrieken.setYPositieVIScherm(rs.getInt("Y_POSITIE_VI_SCHERM"));
    			decadeSchermDefinitieRubrieken.setPlsqlCheck(rs.getString("PLSQL_CHECK"));
    			decadeSchermDefinitieRubrieken.setSorteerSoort(rs.getString("SORTEER_SOORT"));
    			decadeSchermDefinitieRubrieken.setVeldBreedteLovItem(rs.getInt("VELD_BREEDTE_LOVITEM"));
    			decadeSchermDefinitieRubrieken.setMaximumLengte(rs.getInt("MAXIMUM_LENGTE"));
    			decadeSchermDefinitieRubrieken.setDescriptorFunctie(rs.getString("DESCRIPTOR_FUNCTIE"));
    			decadeSchermDefinitieRubrieken.setVasteBeperking(rs.getString("VASTE_BEPERKING"));
    			
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
    
    private String getSQLAllRubrieken() {
    	
    	return "SELECT * " + 
			"FROM DF_RUN_RUBRIEKEN_IN_SCHERM " + 
			"WHERE DRSD_DRPR_DSSM_CODE = 'DF' " + 
			"AND DRSD_DRPR_VERKORTE_NAAM = ? " + 
			"AND DRSD_DRPR_GEBG_CODE = 'DF' " + 
			"AND DRSD_NIVEAU = ? " + 
			"AND RRIS_TYPE = ? " +
			"ORDER BY DRSD_DRPR_DSSM_CODE, " + 
			"DRSD_DRPR_VERKORTE_NAAM, " + 
			"DRSD_DRPR_GEBG_CODE, " +
			"DRSD_NIVEAU, " +
			"RRIS_TYPE, " +
			"VELD_VOLGNUMMER";

    }

    private String getSQLRubriek() {
    	
    	return "SELECT * " + 
			"FROM DF_RUN_RUBRIEKEN_IN_SCHERM " + 
			"WHERE DRSD_DRPR_DSSM_CODE = 'DF' " + 
			"AND DRSD_DRPR_VERKORTE_NAAM = ? " + 
			"AND DRSD_DRPR_GEBG_CODE = 'DF' " + 
			"AND DRSD_NIVEAU = ? " + 
			"AND RRIS_TYPE = ? " +
			"AND KOLM_TABE_NAAM = ? " +
			"AND KOLM_NAAM = ? ";

    }

}