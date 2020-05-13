package com.bracso.test.atomikos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bracso.test.atomikos.entities.Programacion;
import com.bracso.test.atomikos.repository.ProgramacionRepository;

/**
 *
 * @author oburgosm
 */
@Service
public class ProgramacionService {
    
    @Autowired
    private ProgramacionRepository programacionRepository;
    
    @Transactional(readOnly = true)
    public List<Programacion> findAllTransactional() {
        return this.programacionRepository.findAll();
    }
    
    
}
