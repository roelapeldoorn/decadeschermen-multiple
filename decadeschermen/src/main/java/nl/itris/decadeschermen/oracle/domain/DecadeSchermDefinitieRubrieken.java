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
    private int veldTonenAangepast;
   
    private int veldAlleenTonen;
    private int veldAlleenTonenAangepast;
    
    private int veldOpvraagbaar;   
    private int veldOpvraagbaarAangepast;
    
    private int verplicht;
    private int verplichtAangepast;
    private int wijzigbaar;
    private int wijzigbaarAangepast;
    private int hoofdlettersAangepast;
    private int hoofdletters;
    
    private String hintText;
    private String hintTextAangepast;
    
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
	public String getTabelnaam() {
		return tabelnaam;
	}
	public void setTabelnaam(String tabelnaam) {
		this.tabelnaam = tabelnaam;
	}
	public String getKolomnaam() {
		return kolomnaam;
	}
	public void setKolomnaam(String kolomnaam) {
		this.kolomnaam = kolomnaam;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public String getPromptAangepast() {
		return promptAangepast;
	}

	public String getPromptIndex() {
		if (this.promptAangepast != null) {
			return "(*) " + this.promptAangepast;
		}
		return promptAangepast;
	}

	public void setPromptAangepast(String promptAangepast) {
		this.promptAangepast = promptAangepast;
	}
	public int getVeldVolgnummer() {
		return veldVolgnummer;
	}
	public void setVeldVolgnummer(int veldVolgnummer) {
		this.veldVolgnummer = veldVolgnummer;
	}
	public int getVeldVolgnummerAangepast() {
		return veldVolgnummerAangepast;
	}
	public void setVeldVolgnummerAangepast(int veldVolgnummerAangepast) {
		this.veldVolgnummerAangepast = veldVolgnummerAangepast;
	}
	public int getVeldBreedte() {
		return veldBreedte;
	}
	public void setVeldBreedte(int veldBreedte) {
		this.veldBreedte = veldBreedte;
	}
	public int getVeldBreedteAangepast() {
		return veldBreedteAangepast;
	}
	public void setVeldBreedteAangepast(int veldBreedteAangepast) {
		this.veldBreedteAangepast = veldBreedteAangepast;
	}
	public int getVeldTonen() {
		return veldTonen;
	}
	public void setVeldTonen(int veldTonen) {
		this.veldTonen = veldTonen;
	}
	public int getVeldTonenAangepast() {
		return veldTonenAangepast;
	}
	public void setVeldTonenAangepast(int veldTonenAangepast) {
		this.veldTonenAangepast = veldTonenAangepast;
	}
	public int getVeldAlleenTonen() {
		return veldAlleenTonen;
	}
	public void setVeldAlleenTonen(int veldAlleenTonen) {
		this.veldAlleenTonen = veldAlleenTonen;
	}
	public int getVeldAlleenTonenAangepast() {
		return veldAlleenTonenAangepast;
	}
	public void setVeldAlleenTonenAangepast(int veldAlleenTonenAangepast) {
		this.veldAlleenTonenAangepast = veldAlleenTonenAangepast;
	}
	public int getVeldOpvraagbaar() {
		return veldOpvraagbaar;
	}
	public void setVeldOpvraagbaar(int veldOpvraagbaar) {
		this.veldOpvraagbaar = veldOpvraagbaar;
	}
	public int getVeldOpvraagbaarAangepast() {
		return veldOpvraagbaarAangepast;
	}
	public void setVeldOpvraagbaarAangepast(int veldOpvraagbaarAangepast) {
		this.veldOpvraagbaarAangepast = veldOpvraagbaarAangepast;
	}
	public int getVerplicht() {
		return verplicht;
	}
	public void setVerplicht(int verplicht) {
		this.verplicht = verplicht;
	}
	public int getVerplichtAangepast() {
		return verplichtAangepast;
	}
	public void setVerplichtAangepast(int verplichtAangepast) {
		this.verplichtAangepast = verplichtAangepast;
	}
	public int getWijzigbaar() {
		return wijzigbaar;
	}
	public void setWijzigbaar(int wijzigbaar) {
		this.wijzigbaar = wijzigbaar;
	}
	public int getWijzigbaarAangepast() {
		return wijzigbaarAangepast;
	}
	public void setWijzigbaarAangepast(int wijzigbaarAangepast) {
		this.wijzigbaarAangepast = wijzigbaarAangepast;
	}
	public int getHoofdlettersAangepast() {
		return hoofdlettersAangepast;
	}
	public void setHoofdlettersAangepast(int hoofdlettersAangepast) {
		this.hoofdlettersAangepast = hoofdlettersAangepast;
	}
	public int getHoofdletters() {
		return hoofdletters;
	}
	public void setHoofdletters(int hoofdletters) {
		this.hoofdletters = hoofdletters;
	}
	public String getHintText() {
		return hintText;
	}
	public void setHintText(String hintText) {
		this.hintText = hintText;
	}
	public String getHintTextAangepast() {
		return hintTextAangepast;
	}
	public void setHintTextAangepast(String hintTextAangepast) {
		this.hintTextAangepast = hintTextAangepast;
	}
	public void setTypeOmschrijving(String typeOmschrijving) {
		this.typeOmschrijving = typeOmschrijving;
	}

	
}