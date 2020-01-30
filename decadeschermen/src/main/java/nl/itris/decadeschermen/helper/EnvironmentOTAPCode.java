package nl.itris.decadeschermen.helper;

public class EnvironmentOTAPCode {
	
    private String otapcode;
    private String otapname;

    public EnvironmentOTAPCode () {
    	
    }

    public EnvironmentOTAPCode (String otapcode, String otapname) {
		this.otapcode = otapcode;
		this.otapname = otapname;
    }

	public String getOtapcode() {
		return otapcode;
	}

	public String getOtapname() {
		return otapname;
	}
    
}