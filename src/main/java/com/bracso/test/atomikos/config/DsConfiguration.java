package com.bracso.test.atomikos.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bracso.test.atomikos.CustomAtomikosNonXADataSourceBean;

/**
 *
 * @author oburgosm
 */
@Configuration
public class DsConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.ds1")
    public DataSource ds1XA() {
        return new CustomAtomikosNonXADataSourceBean();
    }

    @Bean
    public JdbcTemplate primaryJdbcTemplateXA() {
        return new JdbcTemplate(ds1XA());
    }

}
