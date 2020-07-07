package com.bracso.test.atomikos;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.bracso.test.atomikos.service.ProductService1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author oburgosm
 */
@SpringBootTest(classes = { Application.class })
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration
public class AtomikosTest {
    
    @Autowired
    private PlatformTransactionManager tm;
    
    
    @Autowired
    private ProductService1 productService;
    
    
    @Test
    public void testWithTransactionalAnnotation() {
        this.productService.findAllTransactional();
    }
    
    
    @Test
    public void testJtaTransactionalManager() {
        assertThat(this.tm, instanceOf(JtaTransactionManager.class));
    }
    
    @Test
    public void testUncommitedIsolationLevel() throws SQLException {
        assertThat(this.productService.getUncommittedTransactionIsolationLevel(), is(Connection.TRANSACTION_READ_UNCOMMITTED));
    }
    
    @Test
    public void testCommitedIsolationLevel() throws SQLException {
        assertThat(this.productService.getCommittedTransactionIsolationLevel(), is(Connection.TRANSACTION_READ_COMMITTED));
    }
    
    
    
}
