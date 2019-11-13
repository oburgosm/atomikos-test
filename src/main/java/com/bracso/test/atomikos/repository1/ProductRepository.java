
package com.bracso.test.atomikos.repository1;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bracso.test.atomikos.entities.Product;


/**
 *
 * @author oburgosm
 */
@Repository
@Transactional
public class ProductRepository {
    
    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT id, name FROM Product", (rs, rowcount) -> {
            Product result = new Product();
            result.setId(rs.getLong("id"));
            result.setName(rs.getString("name"));
            return result;
        });
    }
    
    public int insert(Product p) {
        return this.jdbcTemplate.update("INSERT INTO Product(id, name) Values (?, ?)", p.getId(), p.getName());
    }
    
    

}
