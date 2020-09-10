package com.bracso.test.atomikos.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;




/**
 *
 * @author oburgosm
 */
@Configuration
public class DsConfiguration {
    

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.ds1")
    @DependsOn("openTracingDataSourcePostProcessor")
    public DataSource ds1XA()
            throws SQLException {
        return new AtomikosDataSourceBean();
    }
    

}
