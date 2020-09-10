package com.bracso.test.atomikos.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    
    @GetMapping("/products")
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }
    
    @PostMapping("/products")
    @Transactional
    public Product newProduct(@RequestBody Product product) {
        return this.productRepository.saveAndFlush(product);
    }
    
    
    
}
