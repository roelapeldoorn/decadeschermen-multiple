package nl.itris.decadeschermen.oracle.domain;

import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
    
}