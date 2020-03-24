package nl.itris.decadeschermen.oracle.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "DF_RUN_RUBRIEKEN_IN_SCHERM")
public class DecadeSchermDefinitieType {

    @Column(name = "DRSD_DRPR_VERKORTE_NAAM")
    private String verkortenaam;
    @Column(name = "DRSD_NIVEAU")
    private int niveau;
    @Column(name = "RRIS_TYPE")
    private String type;
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