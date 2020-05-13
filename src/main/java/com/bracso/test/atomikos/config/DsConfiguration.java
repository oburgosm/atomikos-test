package com.bracso.test.atomikos.config;

import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;


/**
 *
 * @author oburgosm
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.bracso.test.atomikos.repository")
public class DsConfiguration {
    

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.ds1")
    public DataSource ds1XA()
            throws SQLException {
        return new AtomikosDataSourceBean();
    }
    
    @Bean(name = "entityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            final EntityManagerFactoryBuilder entityManagerFactoryBuilder,
            JpaProperties jpaConfiguration,
            final DataSource dataSource) {
        Map<String, String> jpaProperties = jpaConfiguration.getProperties();
        return entityManagerFactoryBuilder.dataSource(dataSource)
                .persistenceUnit("primaryPersistenceUnit")
                .packages("com.bracso.test.atomikos.entities")
                .properties(jpaProperties)
                .jta(true)
                .build();
    }
    

    @Bean
    public JdbcTemplate primaryJdbcTemplateXA() throws SQLException {
        return new JdbcTemplate(ds1XA());
    }
    

}
