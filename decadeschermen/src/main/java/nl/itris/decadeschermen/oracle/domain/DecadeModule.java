package nl.itris.decadeschermen.oracle.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "RED_OPTIONS")
public class DecadeModule {

    @Id
    @Column(name = "RON_ID")
    private long ronid;

    @Column(name = "RON_OPTION")
    private String ronoption;
	
    @Column(name = "RON_ALLOWED")
    private String ronallowed;
	
    @Column(name = "RON_DESCRIPTION")
    private String rondescription;

	public long getRonid() {
		return ronid;
	}

	public void setRonid(long ronid) {
		this.ronid = ronid;
	}

	public String getRonoption() {
		return ronoption;
	}

	public void setRonoption(String ronoption) {
		this.ronoption = ronoption;
	}

	public String getRonallowed() {
		return ronallowed;
	}

	public void setRonallowed(String ronallowed) {
		this.ronallowed = ronallowed;
	}

	public String getRondescription() {
		return rondescription;
	}

	public void setRondescription(String rondescription) {
		this.rondescription = rondescription;
	}
    
}
