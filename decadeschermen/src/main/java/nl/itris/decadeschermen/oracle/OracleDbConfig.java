package nl.itris.decadeschermen.oracle;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "oracleEntityManagerFactory",
  transactionManagerRef = "oracleTransactionManager",
  basePackages = { "nl.itris.decadeschermen.oracle.repository" }
)
public class OracleDbConfig {
 
  @Bean(name = "oracleDataSource")
  @ConfigurationProperties(prefix = "oracle.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }
  
  @Bean(name = "oracleEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean 
  oracleEntityManagerFactory(
    EntityManagerFactoryBuilder builder,
    @Qualifier("oracleDataSource") DataSource dataSource
  ) {
    return
      builder
        .dataSource(dataSource)
        .packages("nl.itris.decadeschermen.oracle.domain")
        .persistenceUnit("oracle")
        .build();
  }  
  
  @Bean(name = "oracleTransactionManager")
  public PlatformTransactionManager oracleTransactionManager(
    @Qualifier("oracleEntityManagerFactory") EntityManagerFactory
    oracleEntityManagerFactory
  ) {
    return new JpaTransactionManager(oracleEntityManagerFactory);
  }
}