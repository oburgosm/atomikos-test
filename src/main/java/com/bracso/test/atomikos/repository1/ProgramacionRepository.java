
package com.bracso.test.atomikos.repository1;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bracso.test.atomikos.entities.Programacion;


/**
 *
 * @author oburgosm
 */
@Repository
public interface ProgramacionRepository extends JpaRepository<Programacion, Long> {
    

    
    

}
