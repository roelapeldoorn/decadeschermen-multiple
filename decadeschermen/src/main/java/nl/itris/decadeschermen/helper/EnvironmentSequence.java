package nl.itris.decadeschermen.helper;

public class EnvironmentSequence {
	
    private String sequencecode;
    private String sequencename;

    public EnvironmentSequence () {
    	
    }

    public EnvironmentSequence (String sequencecode, String sequencename) {
		this.sequencecode = sequencecode;
		this.sequencename = sequencename;
    }

	public String getSequencecode() {
		return sequencecode;
	}

	public String getSequencename() {
		return sequencename;
	}
    
}
