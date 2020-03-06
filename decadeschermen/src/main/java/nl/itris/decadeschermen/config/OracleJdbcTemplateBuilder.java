package nl.itris.decadeschermen.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import nl.itris.decadeschermen.mysql.domain.DecadeEnvironment;

public class OracleJdbcTemplateBuilder {
	
    public JdbcTemplate getJdbcTemplate(HikariDataSource hikariDataSource) {
        
        return new JdbcTemplate(hikariDataSource);
    	
    }

//    public JdbcTemplate getJdbcTemplate(DecadeEnvironment decadeEnvironment) {
//    	
//    	DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create(); 
//    	    	
//    	dataSourceBuilder.driverClassName("oracle.jdbc.OracleDriver");
//    	dataSourceBuilder.url(decadeEnvironment.getEnvironmenturl());
//        dataSourceBuilder.username(decadeEnvironment.getEnvironmentuser()); 
//        dataSourceBuilder.password(decadeEnvironment.getEnvironmentpassword());
//        
//        DataSource dataSource = dataSourceBuilder.build(); 
//        
//        return new JdbcTemplate(dataSource);
//    	
//    }

    public HikariDataSource getDataSource(DecadeEnvironment decadeEnvironment) {
    
    	   HikariConfig hikariConfig = new HikariConfig();
    	     
    	   hikariConfig.setJdbcUrl("oracle.jdbc.OracleDriver");
    	   hikariConfig.setJdbcUrl(decadeEnvironment.getEnvironmenturl());
    	   hikariConfig.setUsername(decadeEnvironment.getEnvironmentuser());
    	   hikariConfig.setPassword(decadeEnvironment.getEnvironmentpassword());
    	   hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
    	   hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
    	   hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
 
    	   return new HikariDataSource(hikariConfig);
    	   
    }
    
}