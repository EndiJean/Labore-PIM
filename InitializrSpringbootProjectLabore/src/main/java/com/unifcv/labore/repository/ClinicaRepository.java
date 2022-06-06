package com.unifcv.labore.repository;

import com.unifcv.labore.model.Clinica;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Integer>{
    
    @Query("select p from Clinica p where p.nome like :nome")
    List<Clinica> findByNomeLike(@Param("nome") String nome);
    
}
