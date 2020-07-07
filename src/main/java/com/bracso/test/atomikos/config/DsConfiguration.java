package com.bracso.test.atomikos.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.transaction.PlatformTransactionManagerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.jta.JtaTransactionManager;



/**
 *
 * @author oburgosm
 */
@Configuration
public class DsConfiguration {
    
    @Bean
    public PlatformTransactionManagerCustomizer<JtaTransactionManager> myPlatformTransactionManagerCustomizer() {
        return (JtaTransactionManager transactionManager) -> {
            transactionManager.setAllowCustomIsolationLevels(true);
        };
    }
    
//    @Bean
//    public IsolationPostProcessor isolationPostProcessor() {
//        return new IsolationPostProcessor();
//    }
    

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.ds1")
    public DataSource ds1XA() throws SQLException {
        return new AtomikosDataSourceBean();
    }

    @Bean
    public JdbcTemplate primaryJdbcTemplateXA() throws SQLException {
        return new JdbcTemplate(ds1XA());
    }
    

}
