package nl.itris.decadeschermen.helper;

import java.util.List;
import java.util.Vector;

public class DatabasetypeList {

	public DatabasetypeList () {
	}
	
	public List<Databasetype> getDatabasetypes () {
		
		List<Databasetype> listDatabaseTypes = new Vector<Databasetype>();
        
		listDatabaseTypes.add(new Databasetype("oracle", "Oracle Database"));
		listDatabaseTypes.add(new Databasetype("sqlserver", "Microsoft SQL Server"));	
		listDatabaseTypes.add(new Databasetype("mysql", "MySQL database"));	
		listDatabaseTypes.add(new Databasetype("postgresql", "Postgre SQL datase"));	
		listDatabaseTypes.add(new Databasetype("db2", "IBM DB2 database"));	

        return listDatabaseTypes;
        
	}

}