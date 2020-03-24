package nl.itris.decadeschermen.oracle.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "DF_RUN_RUBRIEKEN_IN_SCHERM")
public class DecadeSchermDefinitieNiveau {

    @Column(name = "DRSD_DRPR_VERKORTE_NAAM")
    private String verkortenaam;
    @Column(name = "DRSD_NIVEAU")
    private int niveau;

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
	
}