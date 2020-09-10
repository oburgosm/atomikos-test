package com.bracso.test.atomikos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bracso.test.atomikos.entities.Product;
import com.bracso.test.atomikos.repository1.ProductRepository;

/**
 *
 * @author oburgosm
 */
@RestController
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;
    
    
    @GetMapping("/greeting")
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }
    
    
}
