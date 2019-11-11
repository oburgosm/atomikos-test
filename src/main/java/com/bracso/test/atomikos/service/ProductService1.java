package com.bracso.test.atomikos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bracso.test.atomikos.entities.Product;
import com.bracso.test.atomikos.repository1.ProductRepository1;

/**
 *
 * @author oburgosm
 */
@Component
public class ProductService1 {
    
    @Autowired
    private ProductRepository1 productRepository;
    
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }
    
}
