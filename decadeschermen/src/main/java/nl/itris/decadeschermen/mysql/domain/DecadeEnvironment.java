package nl.itris.decadeschermen.mysql.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "environment")
@NamedQuery(name = "DecadeEnvironment.findAll", query="select u from DecadeEnvironment u order by u.environmenturl")
public class DecadeEnvironment {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "environmentid")
    private long environmentid;

    @NotBlank(message = "JDBC URL is verplicht.")
    @Column(name = "environmenturl")
    private String environmenturl;

    @NotBlank(message = "Type database is verplicht.")
    @Column(name = "environmentdatabasetype")
    private String environmentdatabasetype;

    @NotBlank(message = "Gebruikersnaam is verplicht.")
    @Column(name = "environmentuser")
    private String environmentuser;

    @NotBlank(message = "Wachtwoord is verplicht.")
    @Column(name = "environmentpassword")
    private String environmentpassword;

    @NotBlank(message = "Klantcode is verplicht.")
    @Size(min = 4, max = 4, message = "Klantcode dient 4 tekens te zijn.")
    @Column(name = "environmentcustomercode")
    private String environmentcustomercode;

    @NotBlank(message = "OTAP is verplicht.")
    @Size(min = 1, max = 1, message = "Geef een O, T, A, of P op.")
    @Column(name = "environmentotap")
    private String environmentotap;

    @NotBlank(message = "Volgnummer is verplicht.")
    @Column(name = "environmentsequence")
    private String environmentsequence;

	public long getEnvironmentid() {
		return environmentid;
	}

	public void setEnvironmentid(long environmentid) {
		this.environmentid = environmentid;
	}

	public String getEnvironmenturl() {
		return environmenturl;
	}

	public void setEnvironmenturl(String environmenturl) {
		this.environmenturl = environmenturl;
	}

	public String getEnvironmentuser() {
		return environmentuser;
	}

	public void setEnvironmentuser(String environmentuser) {
		this.environmentuser = environmentuser;
	}

	public String getEnvironmentpassword() {
		return environmentpassword;
	}

	public void setEnvironmentpassword(String environmentpassword) {
		this.environmentpassword = environmentpassword;
	}

	public String getEnvironmentdatabasetype() {
		return environmentdatabasetype;
	}

	public void setEnvironmentdatabasetype(String environmentdatabasetype) {
		this.environmentdatabasetype = environmentdatabasetype;
	}

	public String getEnvironmentcustomercode() {
		return environmentcustomercode;
	}

	public void setEnvironmentcustomercode(String environmentcustomercode) {
		this.environmentcustomercode = environmentcustomercode.toUpperCase();
	}

	public String getEnvironmentotap() {
		return environmentotap;
	}

	public void setEnvironmentotap(String environmentotap) {
		this.environmentotap = environmentotap;
	}

	public String getEnvironmentsequence() {
		return environmentsequence;
	}

	public void setEnvironmentsequence(String environmentsequence) {
		this.environmentsequence = environmentsequence;
	}

	public String getEnvironmentcode() {
		return environmentcustomercode + environmentotap + environmentsequence;
	}

	
    
}