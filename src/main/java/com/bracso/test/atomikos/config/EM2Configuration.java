package com.bracso.test.atomikos.config;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 *
 * @author oburgosm
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "ds2EntityManager",
        basePackages = { "com.bracso.test.atomikos.repository2" })
public class EM2Configuration {
    
    @Resource
    private DataSource ds2;

    
    
    
    @Bean(name = "ds2EntityManager")
    public LocalContainerEntityManagerFactoryBean ds2EntityManager(EntityManagerFactoryBuilder builder,
            JpaProperties jpaConfiguration) throws SQLException {

        return builder.dataSource(this.ds2)
            .persistenceUnit("ds2PersistenceUnit")
            .packages("com.bracso.test.atomikos.entities")
            .properties(jpaConfiguration.getProperties())
            .jta(true)
            .build();
    }
    
}
