package com.unifcv.labore.repository;

import com.unifcv.labore.model.Geral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GeralRepository extends JpaRepository<Geral, Integer>{
    
    /*
    @Query("SELECT g FROM Geral g JOIN FECTH g.Anexos where c.id = :id")
    Optional<Geral> findGeral(@Param("id") Integer id);
    */
}
