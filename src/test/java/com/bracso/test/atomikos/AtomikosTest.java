package com.bracso.test.atomikos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bracso.test.atomikos.entities.Product;
import com.bracso.test.atomikos.service.ProductService1;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 *
 * @author oburgosm
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
@EnableAutoConfiguration
public class AtomikosTest {
    
    
    @Autowired
    private ProductService1 productService;
    

    
    /**
     * Changing atomikos.version, we have different behaviour
     */
    @Test
    public void testDoubleInsert() {
        int size = this.productService.findAll().size();
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Product 1");
        
        try {
            this.productService.badInsert(product1);
            fail("It must fail");
        } catch (RuntimeException e) {
            //OK
        }
        assertThat(this.productService.findAll().size(), is(equalTo(size)));
    }
    
}
