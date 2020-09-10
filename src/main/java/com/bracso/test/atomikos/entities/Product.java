package com.bracso.test.atomikos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *
 * @author oburgosm
 */
@Entity
public class Product implements Serializable {

    @Id
    private Long id;
    private String name;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
