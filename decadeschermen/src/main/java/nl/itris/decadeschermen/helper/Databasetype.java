package nl.itris.decadeschermen.helper;

public class Databasetype {
	
    private String databasecode;
    private String databasename;

    public Databasetype () {
    	
    }

    public Databasetype (String databasecode, String databasename) {
		this.databasecode = databasecode;
		this.databasename = databasename;
    }

	public String getDatabasecode() {
		return databasecode;
	}

	public String getDatabasename() {
		return databasename;
	}
    
}

