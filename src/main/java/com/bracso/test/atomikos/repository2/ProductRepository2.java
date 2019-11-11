
package com.bracso.test.atomikos.repository2;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bracso.test.atomikos.entities.Product;

/**
 *
 * @author oburgosm
 */
@Repository
public interface ProductRepository2 extends JpaRepository<Product, Long>{

}
