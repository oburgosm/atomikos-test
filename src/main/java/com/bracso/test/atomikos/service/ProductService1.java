package com.bracso.test.atomikos.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bracso.test.atomikos.entities.Product;
import com.bracso.test.atomikos.repository1.ProductRepository;

/**
 *
 * @author oburgosm
 */
@Service
public class ProductService1 {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Transactional(readOnly = true)
    public List<Product> findAllTransactional() {
        return this.productRepository.findAll();
    }
    
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }
    
    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public int getUncommittedTransactionIsolationLevel() throws SQLException {
        return this.productRepository.getTransactionIsolationLevel();
    }
    
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public int getCommittedTransactionIsolationLevel() throws SQLException {
        return this.productRepository.getTransactionIsolationLevel();
    }
    
}
