package nl.itris.decadeschermen.oracle.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;

@Component
public class DefaultDao {

	protected JdbcTemplate jdbcTemplateObject;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplateObject) {
	    this.jdbcTemplateObject = jdbcTemplateObject;  
	}  

	public void closeJdbcTemplateConnection() {
		 try {
			 System.out.println("Connection closed for " + jdbcTemplateObject.getDataSource().getConnection().getSchema());
			 this.jdbcTemplateObject.getDataSource().getConnection().close();
		 } catch (SQLException e) {
		    e.printStackTrace();
		 }	 
	}
	
	public Connection getConnection(DecadeEnvironment decadeEnvironment) throws Exception {

		Connection connection = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
			connection = DriverManager.getConnection(
					decadeEnvironment.getEnvironmenturl().trim(), 
					decadeEnvironment.getEnvironmentuser().trim(), 
					decadeEnvironment.getEnvironmentpassword().trim());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Verbinden met database " + decadeEnvironment.getEnvironmenturl().trim() + " is mislukt (" + 
					e.getMessage() + ")");
		}
		
		return connection;

	}

	public String closeConnection(Connection connection) throws Exception {
		
		try {
			connection.close();
			return "Verbinding met database is verbroken.";
		} catch (Exception e) {
			throw new Exception("Verbreken verbinding is mislukt (" + e.getMessage() + ")");
		}
		
	}
	
    
}