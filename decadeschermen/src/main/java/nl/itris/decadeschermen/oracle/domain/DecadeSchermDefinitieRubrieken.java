package nl.itris.decadeschermen.oracle.domain;

public class DecadeSchermDefinitieRubrieken {

    private String verkortenaam;
    private int niveau;
    private String type;
    
    private String tabelNaam;
    private String tabelKolomnaam;
    private String tabelDssmCode;
    
    private String prompt;
    private int indicatieOpvraagbaar;   
    private int indicatieVeldTonen;   
    private int veldVolgnummer;
    private int veldBreedte;
    private int sorteerVolgorde;
    private int indicatieLeegVeldVolgen;
    private int indicatieVerplicht;
    private int indicatieHoofdletters;
    private int indicatieVasteLengte;
    private int indicatieWijzigbaar;
    private int indicatieDisplayOnly;
    private String wijzeVanTonen;
    private String naamPopList;
    private String naamLov;
    private String hintText;
    private String helptekstDeelsysteem;
    private String helptekstGebruiker;
    private int indicatieOpvraagbaarVerplicht;
    private int xPositieVIScherm;
    private int yPositieVIScherm;
    private String plsqlCheck;
    private String sorteerSoort;
    private int veldBreedteLovItem;
    private int maximumLengte;
    private String descriptorFunctie;
    private String vasteBeperking;

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

	public String getTypeTekst() {
		if (type.toUpperCase().equals("RIN")) {
			return "Navigatiescherm";
		} else if (type.toUpperCase().equals("ROS")) {
			return "Overzichtsscherm";
		} else if (type.toUpperCase().equals("RPP")) {
			return "Eigenschappenscherm";
		} else if (type.toUpperCase().equals("RVI")) {
			return "Variabel invoerscherm";
		} else {
			return "Onbekend";
		}
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTabelNaam() {
		return tabelNaam;
	}
	public void setTabelNaam(String tabelNaam) {
		this.tabelNaam = tabelNaam;
	}
	public String getTabelKolomnaam() {
		return tabelKolomnaam;
	}
	public void setTabelKolomnaam(String tabelKolomnaam) {
		this.tabelKolomnaam = tabelKolomnaam;
	}
	public String getTabelDssmCode() {
		return tabelDssmCode;
	}
	public void setTabelDssmCode(String tabelDssmCode) {
		this.tabelDssmCode = tabelDssmCode;
	}

	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	public int getIndicatieOpvraagbaar() {
		return indicatieOpvraagbaar;
	}
	public void setIndicatieOpvraagbaar(int indicatieOpvraagbaar) {
		this.indicatieOpvraagbaar = indicatieOpvraagbaar;
	}
	public int getIndicatieVeldTonen() {
		return indicatieVeldTonen;
	}
	public void setIndicatieVeldTonen(int indicatieVeldTonen) {
		this.indicatieVeldTonen = indicatieVeldTonen;
	}
	public int getVeldVolgnummer() {
		return veldVolgnummer;
	}
	public void setVeldVolgnummer(int veldVolgnummer) {
		this.veldVolgnummer = veldVolgnummer;
	}
	public int getVeldBreedte() {
		return veldBreedte;
	}
	public void setVeldBreedte(int veldBreedte) {
		this.veldBreedte = veldBreedte;
	}
	public int getSorteerVolgorde() {
		return sorteerVolgorde;
	}
	public void setSorteerVolgorde(int sorteerVolgorde) {
		this.sorteerVolgorde = sorteerVolgorde;
	}
	public int getIndicatieLeegVeldVolgen() {
		return indicatieLeegVeldVolgen;
	}
	public void setIndicatieLeegVeldVolgen(int indicatieLeegVeldVolgen) {
		this.indicatieLeegVeldVolgen = indicatieLeegVeldVolgen;
	}
	public int getIndicatieVerplicht() {
		return indicatieVerplicht;
	}
	public void setIndicatieVerplicht(int indicatieVerplicht) {
		this.indicatieVerplicht = indicatieVerplicht;
	}
	public int getIndicatieHoofdletters() {
		return indicatieHoofdletters;
	}
	public void setIndicatieHoofdletters(int indicatieHoofdletters) {
		this.indicatieHoofdletters = indicatieHoofdletters;
	}
	public int getIndicatieVasteLengte() {
		return indicatieVasteLengte;
	}
	public void setIndicatieVasteLengte(int indicatieVasteLengte) {
		this.indicatieVasteLengte = indicatieVasteLengte;
	}
	public int getIndicatieWijzigbaar() {
		return indicatieWijzigbaar;
	}
	public void setIndicatieWijzigbaar(int indicatieWijzigbaar) {
		this.indicatieWijzigbaar = indicatieWijzigbaar;
	}
	public int getIndicatieDisplayOnly() {
		return indicatieDisplayOnly;
	}
	public void setIndicatieDisplayOnly(int indicatieDisplayOnly) {
		this.indicatieDisplayOnly = indicatieDisplayOnly;
	}
	public String getWijzeVanTonen() {
		return wijzeVanTonen;
	}
	public void setWijzeVanTonen(String wijzeVanTonen) {
		this.wijzeVanTonen = wijzeVanTonen;
	}
	public String getNaamPopList() {
		return naamPopList;
	}
	public void setNaamPopList(String naamPopList) {
		this.naamPopList = naamPopList;
	}
	public String getNaamLov() {
		return naamLov;
	}
	public void setNaamLov(String naamLov) {
		this.naamLov = naamLov;
	}
	public String getHintText() {
		return hintText;
	}
	public void setHintText(String hintText) {
		this.hintText = hintText;
	}
	public String getHelptekstDeelsysteem() {
		return helptekstDeelsysteem;
	}
	public void setHelptekstDeelsysteem(String helptekstDeelsysteem) {
		this.helptekstDeelsysteem = helptekstDeelsysteem;
	}
	public String getHelptekstGebruiker() {
		return helptekstGebruiker;
	}
	public void setHelptekstGebruiker(String helptekstGebruiker) {
		this.helptekstGebruiker = helptekstGebruiker;
	}
	public int getIndicatieOpvraagbaarVerplicht() {
		return indicatieOpvraagbaarVerplicht;
	}
	public void setIndicatieOpvraagbaarVerplicht(int indicatieOpvraagbaarVerplicht) {
		this.indicatieOpvraagbaarVerplicht = indicatieOpvraagbaarVerplicht;
	}
	public int getXPositieVIScherm() {
		return xPositieVIScherm;
	}
	public void setXPositieVIScherm(int xPositieVIScherm) {
		this.xPositieVIScherm = xPositieVIScherm;
	}
	public int getYPositieVIScherm() {
		return yPositieVIScherm;
	}
	public void setYPositieVIScherm(int yPositieVIScherm) {
		this.yPositieVIScherm = yPositieVIScherm;
	}
	public String getPlsqlCheck() {
		return plsqlCheck;
	}
	public void setPlsqlCheck(String plsqlCheck) {
		this.plsqlCheck = plsqlCheck;
	}
	public String getSorteerSoort() {
		return sorteerSoort;
	}
	public void setSorteerSoort(String sorteerSoort) {
		this.sorteerSoort = sorteerSoort;
	}
	public int getVeldBreedteLovItem() {
		return veldBreedteLovItem;
	}
	public void setVeldBreedteLovItem(int veldBreedteLovItem) {
		this.veldBreedteLovItem = veldBreedteLovItem;
	}
	public int getMaximumLengte() {
		return maximumLengte;
	}
	public void setMaximumLengte(int maximumLengte) {
		this.maximumLengte = maximumLengte;
	}
	public String getDescriptorFunctie() {
		return descriptorFunctie;
	}
	public void setDescriptorFunctie(String descriptorFunctie) {
		this.descriptorFunctie = descriptorFunctie;
	}
	public String getVasteBeperking() {
		return vasteBeperking;
	}
	public void setVasteBeperking(String vasteBeperking) {
		this.vasteBeperking = vasteBeperking;
	}
   

}