package com.bracso.test.atomikos.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author oburgosm
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "ds1EntityManager",
        basePackages = {"com.bracso.test.atomikos.repository1"})
public class Ds1Configuration {
    
    private static final Logger LOG = LoggerFactory.getLogger(Ds1Configuration.class);

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.ds1")
    public DataSource ds1XA()
            throws SQLException {
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "ds1EntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean ds1EntityManager(EntityManagerFactoryBuilder emBuilder, JpaProperties jpaConfiguration) throws SQLException {
        return emBuilder.dataSource(ds1XA())
                .persistenceUnit("ds1PersistenceUnit")
                .packages("com.bracso.test.atomikos.entities")
                .properties(jpaConfiguration.getProperties())
                .jta(true)
                .build();
    }

}
