package nl.itris.decadeschermen.mysql;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "mysqlEntityManagerFactory",
  transactionManagerRef = "mysqlTransactionManager",
  basePackages = { "nl.itris.decadeschermen.mysql.repository" }
)
public class MysqlDbConfig {
  
  @Primary
  @Bean(name = "mysqlDataSource")
  @ConfigurationProperties("mysql.datasource")
  public DataSource dataSource() {
	  return DataSourceBuilder.create().build();
  }
  
  @Primary
  @Bean(name = "mysqlEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean 
  mysqlEntityManagerFactory(
    EntityManagerFactoryBuilder builder,
    @Qualifier("mysqlDataSource") DataSource dataSource
  ) {
    return builder
      .dataSource(dataSource)
      .packages("nl.itris.decadeschermen.mysql.domain")
      .persistenceUnit("mysql")
      .build();
  }
    
  @Primary
  @Bean(name = "mysqlTransactionManager")
  public PlatformTransactionManager transactionManager(
    @Qualifier("mysqlEntityManagerFactory") EntityManagerFactory 
    mysqlEntityManagerFactory
  ) {
    return new JpaTransactionManager(mysqlEntityManagerFactory);
  }
}