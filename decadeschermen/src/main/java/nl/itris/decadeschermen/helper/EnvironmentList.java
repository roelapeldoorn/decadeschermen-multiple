package nl.itris.decadeschermen.helper;

import java.util.List;
import java.util.Vector;

public class EnvironmentList {

	public EnvironmentList () {
	}
	
	public List<EnvironmentOTAPCode> getOTAPCodes () {
		
		List<EnvironmentOTAPCode> listEnvironmentOTAPCodes = new Vector<EnvironmentOTAPCode>();
        
		listEnvironmentOTAPCodes.add(new EnvironmentOTAPCode("O", "Ontwikkeling"));
		listEnvironmentOTAPCodes.add(new EnvironmentOTAPCode("T", "Test"));	
		listEnvironmentOTAPCodes.add(new EnvironmentOTAPCode("A", "Acceptatie"));
		listEnvironmentOTAPCodes.add(new EnvironmentOTAPCode("P", "Productie"));

        return listEnvironmentOTAPCodes;
        
	}

	public List<EnvironmentSequence> getSequences () {
		
		List<EnvironmentSequence> listEnvironmentSequences = new Vector<EnvironmentSequence>();
        
		listEnvironmentSequences.add(new EnvironmentSequence("1", "1"));
		listEnvironmentSequences.add(new EnvironmentSequence("2", "2"));	
		listEnvironmentSequences.add(new EnvironmentSequence("3", "3"));
		listEnvironmentSequences.add(new EnvironmentSequence("4", "4"));
		listEnvironmentSequences.add(new EnvironmentSequence("5", "5"));
		listEnvironmentSequences.add(new EnvironmentSequence("6", "6"));	
		listEnvironmentSequences.add(new EnvironmentSequence("7", "7"));
		listEnvironmentSequences.add(new EnvironmentSequence("8", "8"));
		listEnvironmentSequences.add(new EnvironmentSequence("9", "9"));

        return listEnvironmentSequences;
        
	}
	
}