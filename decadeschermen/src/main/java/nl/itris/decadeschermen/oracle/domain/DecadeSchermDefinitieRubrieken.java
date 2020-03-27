package nl.itris.decadeschermen.oracle.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

public class DecadeSchermDefinitieRubrieken {

    private String verkortenaam;
    private int niveau;
    private String type;
    
    private String tabelnaam;
    private String kolomnaam;
    
    private String prompt;
    private String promptAangepast;
    
    private int veldVolgnummer;
    private int veldVolgnummerAangepast;
    private int veldBreedte;
    private int veldBreedteAangepast;

    private int veldTonen;
    
    private int veldAlleenTonen;
    
    private int veldOpvraagbaar;
    
    private int 
    IND_VELD_TONEN
    IND_VELD_TONEN_AANGP
    IND_DISPLAY_ONLY
    IND_DISPLAY_ONLY_AANGP
    IND_OPVRAAGBAAR
    IND_OPVRAAGBAAR_AANGP
    IND_VERPLICHT
    IND_VERPLICHT_AANGP
    IND_WIJZIGBAAR
    IND_WIJZIGBAAR_AANGP
    IND_HOOFDLETTERS
    IND_HOOFDLETTERS_AANGP
    HINT_TEXT
    HINT_TEXT_AANGP
   
   
    private String typeOmschrijving;
    
    
	public String getVerkortenaam() {
		return verkortenaam;
	}
	public void setVerkortenaam(String verkortenaam) {
		this.verkortenaam = verkortenaam;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
		if (type.toUpperCase().equals("RIN")) {
			this.typeOmschrijving = "Navigatiescherm";
		} else if (type.toUpperCase().equals("ROS")) {
			this.typeOmschrijving = "Overzichtsscherm";
		} else if (type.toUpperCase().equals("RPP")) {
			this.typeOmschrijving = "Eigenschappenscherm";
		} else if (type.toUpperCase().equals("RVI")) {
			this.typeOmschrijving = "Variabel invoerscherm";
		} else {
			this.typeOmschrijving = "Onbekend";
		}
	}
	public String getTypeOmschrijving() {
		return typeOmschrijving;
	}

	
}