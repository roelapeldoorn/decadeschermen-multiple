package nl.itris.decadeschermen.oracle.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "DF_RUN_SCHERM_DEFINITIES")
public class DecadeSchermDefinitie {

    @Column(name = "DRPR_VERKORTE_NAAM")
    private String verkortenaam;

	public String getVerkortenaam() {
		return verkortenaam;
	}

	public void setVerkortenaam(String verkortenaam) {
		this.verkortenaam = verkortenaam;
	}
    
}
