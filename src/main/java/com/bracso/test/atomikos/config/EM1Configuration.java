package com.bracso.test.atomikos.config;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;


/**
 *
 * @author oburgosm
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "ds1EntityManager",
        basePackages = {"com.bracso.test.atomikos.repository1"})
public class EM1Configuration {

    @Resource
    private DataSource ds1;


    @Bean(name = "ds1EntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean ds1EntityManager(EntityManagerFactoryBuilder emBuilder,
            JpaProperties jpaConfiguration) throws SQLException {

        return emBuilder.dataSource(this.ds1)
                .persistenceUnit("ds1PersistenceUnit")
                .packages("com.bracso.test.atomikos.entities")
                .properties(jpaConfiguration.getProperties())
                .jta(true)
                .build();
    }

}
