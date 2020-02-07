package nl.itris.decadeschermen.oracle.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "V_RED_ORGANIZATIONS")
public class ViewpointOrganization {

    @Id
    @Column(name = "ROS_ID")
    private long rosid;

    @Column(name = "ROS_ORGANIZATION_NAME")
    private String rosorganisationname;

	public long getRosid() {
		return rosid;
	}

	public void setRosid(long rosid) {
		this.rosid = rosid;
	}

	public String getRosorganisationname() {
		return rosorganisationname;
	}

	public void setRosorganisationname(String rosorganisationname) {
		this.rosorganisationname = rosorganisationname;
	}
    
}

