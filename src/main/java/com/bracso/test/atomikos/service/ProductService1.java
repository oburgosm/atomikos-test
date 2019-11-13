package com.bracso.test.atomikos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }
    
    @Transactional
    public int insert(Product p) {
        return this.productRepository.insert(p);
    }
    
    /**
     * We insert two products, expecting that it fail and rollback
     * @param p
     * @return 
     */
    @Transactional
    public int badInsert(Product p) {
        this.productRepository.insert(p);
        return this.productRepository.insert(p);
    }
    
}
