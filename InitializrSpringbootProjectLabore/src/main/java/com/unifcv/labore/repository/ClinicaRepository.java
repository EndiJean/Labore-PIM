package com.unifcv.labore.repository;

import com.unifcv.labore.model.Clinica;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Integer>{
    
    Optional<Clinica> findByNome (String nome);
    
}
