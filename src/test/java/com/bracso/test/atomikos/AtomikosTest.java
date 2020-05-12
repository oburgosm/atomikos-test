package com.bracso.test.atomikos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bracso.test.atomikos.service.ProgramacionService;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author oburgosm
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
@EnableAutoConfiguration
public class AtomikosTest {
    
    
    @Autowired
    private ProgramacionService programacionService;
    

    
    @Test
    public void testWithTransactionalAnnotation() {
        this.programacionService.findAllTransactional();
    }
    
    /**
     * Why I need @Transactional annotation on a query method?
     */
    @Test
    public void testWithoutTransactionalAnnotation() {
        this.programacionService.findAll();
    }
    
}
