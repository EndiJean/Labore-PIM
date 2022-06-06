package com.unifcv.labore.repository;

import com.unifcv.labore.model.Medico;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer>{
    
    @Query("select p from Medico p where p.nome like :nome")
    List<Medico> findByNomeLike(@Param("nome") String nome);
    
}
