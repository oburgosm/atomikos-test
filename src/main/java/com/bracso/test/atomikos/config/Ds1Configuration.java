package com.bracso.test.atomikos.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.atomikos.jdbc.AtomikosNonXADataSourceBean;


/**
 *
 * @author oburgosm
 */
@Configuration
public class Ds1Configuration {
    

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.ds1")
    public DataSource ds1()
            throws SQLException {
        return new AtomikosNonXADataSourceBean();
    }



}
