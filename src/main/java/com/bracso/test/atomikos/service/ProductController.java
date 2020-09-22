package com.bracso.test.atomikos.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bracso.test.atomikos.entities.Product;
import com.bracso.test.atomikos.repository1.ProductRepository1;
import com.bracso.test.atomikos.repository2.ProductRepository2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

/**
 * @author Capgemini
 */
@Validated
@RestController
@RequestMapping(path = "/product")
@Api(authorizations = @Authorization(value = "ItxApiKey", scopes = {}))
public class ProductController {

    @Resource
    private ProductRepository1 productRepository1;

    @Resource
    private ProductRepository2 productRepository2;

    /**
     * Insert first product to repo1 and second product to repo2
     * 
     *
     * @param name1 Product name for repo1
     * @param name2 Product name for repo2
     * @return List with two saved products. First from repo1 and second from repo2
     * @throws SQLException
     */
    @GetMapping("{name1}/{name2}")
    @Transactional
    @ApiOperation("Insert first product to repo1 and second product to repo2")
    public List<Product> insert2Products(@PathVariable String name1, @PathVariable String name2) throws SQLException {
        Product product1 = new Product();
        product1.setName(name1);
        Product product2 = new Product();
        product2.setName(name2);
        this.productRepository1.save(product1);
        this.productRepository2.save(product2);
        List<Product> result = new ArrayList<>();
        result.add(product1);
        result.add(product2);
        return result;
    }

    /**
     * Insert two products to repo1
     *
     * @param name1 Product name for first product
     * @param name2 Product name for second product
     * @return List with two saved products on repo1
     * @throws SQLException
     */
    @GetMapping("/insert1/{name1}/{name2}")
    @Transactional
    @ApiOperation("Insert two products to repo1")
    public List<Product> insert2ProductsInDS1(@PathVariable String name1, @PathVariable String name2)
            throws SQLException {
        Product product1 = new Product();
        product1.setName(name1);
        Product product2 = new Product();
        product2.setName(name2);
        this.productRepository1.save(product1);
        this.productRepository1.save(product2);
        List<Product> result = new ArrayList<>();
        result.add(product1);
        result.add(product2);
        return result;
    }

    /**
     * Insert two products to repo2
     *
     * @param name1 Product name for first product
     * @param name2 Product name for second product
     * @return List with two saved products on repo2
     * @throws SQLException
     */
    @GetMapping("/insert2/{name1}/{name2}")
    @Transactional
    @ApiOperation("Insert two products to repo2")
    public List<Product> insert2ProductsInDS2(@PathVariable String name1, @PathVariable String name2)
            throws SQLException {
        Product product1 = new Product();
        product1.setName(name1);
        Product product2 = new Product();
        product2.setName(name2);
        this.productRepository2.save(product1);
        this.productRepository2.save(product2);
        List<Product> result = new ArrayList<>();
        result.add(product1);
        result.add(product2);
        return result;
    }

    /**
     * List repo1
     *
     * @return
     */
    @GetMapping("list1")
    @ApiOperation("List repo1")
    public List<Product> findAll_1() {
        this.productRepository1.findAll();
        return this.productRepository1.findAll();
    }

    /**
     * Lista el repository2
     *
     * @return
     */
    @GetMapping("list2")
    @ApiOperation("List repo2")
    public List<Product> findAll_2() {
        this.productRepository2.findAll();
        return this.productRepository2.findAll();
    }

}
