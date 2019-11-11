package com.bracso.test.atomikos.config;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
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
        basePackages = {"com.bracso.test.atomikos.repository2"})
public class Ds2Configuration {


    @Bean
    @ConfigurationProperties(prefix = "datasource.ds2")
    public DataSource ds2XA() throws SQLException {
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "ds2EntityManager")
    public LocalContainerEntityManagerFactoryBean ds2EntityManager(EntityManagerFactoryBuilder builder,
            JpaProperties jpaConfiguration
    ) throws SQLException {

        return builder.dataSource(ds2XA())
                .persistenceUnit("ds2PersistenceUnit")
                .packages("com.bracso.test.atomikos.entities")
                .properties(jpaConfiguration.getProperties())
                .jta(true)
                .build();
    }
//
//    @Bean
//    public DataSourceInitializer ds2Initializer() throws SQLException {
//        DataSourceInitializer initializer = new DataSourceInitializer();
//        initializer.setDataSource(ds2XA());
//        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(new ClassPathResource("schema-h2.sql"));
//        initializer.setDatabasePopulator(populator);
//        initializer.setEnabled(true);
//        return initializer;
//    }

}
