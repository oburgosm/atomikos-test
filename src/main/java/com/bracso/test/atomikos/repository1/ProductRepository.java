
package com.bracso.test.atomikos.repository1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bracso.test.atomikos.entities.Product;


/**
 *
 * @author oburgosm
 */
@Repository
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
    
    public int getTransactionIsolationLevel() throws SQLException {
        try (Connection c = this.jdbcTemplate.getDataSource().getConnection()) {
            return c.getTransactionIsolation();
        }
    }
    
    

}
