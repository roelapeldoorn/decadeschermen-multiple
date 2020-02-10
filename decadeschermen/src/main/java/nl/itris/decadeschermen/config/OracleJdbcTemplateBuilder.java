package nl.itris.decadeschermen.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;

public class OracleJdbcTemplateBuilder {
	
    public JdbcTemplate getJdbcTemplate(DecadeEnvironment decadeEnvironment) {
    	
    	DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create(); 
    	
    	    	
    	dataSourceBuilder.driverClassName("oracle.jdbc.OracleDriver");
    	dataSourceBuilder.url(decadeEnvironment.getEnvironmenturl());
        dataSourceBuilder.username(decadeEnvironment.getEnvironmentuser()); 
        dataSourceBuilder.password(decadeEnvironment.getEnvironmentpassword());
        
        DataSource dataSource = dataSourceBuilder.build(); 
        
        return new JdbcTemplate(dataSource);
    	
    }

    

}
