package nl.itris.decadeschermen.oracle.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "DF_STAND_SCHERM_DEFINITIES")
public class DecadeSchermDefinitie {

    @Column(name = "STPD_VERKORTE_NAAM")
    private String stpdverkortenaam;

	public String getStpdverkortenaam() {
		return stpdverkortenaam;
	}

	public void setStpdverkortenaam(String stpdverkortenaam) {
		this.stpdverkortenaam = stpdverkortenaam;
	}
    
}
