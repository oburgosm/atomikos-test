package com.bracso.test.atomikos.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * @author oburgosm
 */
@Configuration
public class Ds2Configuration {
    

    @Bean
    @ConfigurationProperties(prefix = "datasource.ds2-xa")
    public DataSource ds2()
            throws SQLException {
        return new AtomikosDataSourceBean();
    }



}
