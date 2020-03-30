package nl.itris.decadeschermen.oracle.domain;

public class DecadeSchermDefinitieWerkVanuit {

    private String verkortenaam;
    private int niveau;
    private String type;
    private String typeOmschrijving;
	private String werkVanuit;
    
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

    public String getWerkVanuit() {
		return werkVanuit;
	}
	public void setWerkVanuit(String werkVanuit) {
		this.werkVanuit = werkVanuit;
	}

}