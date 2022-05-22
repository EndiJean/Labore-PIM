package com.unifcv.labore.repository;

import com.unifcv.labore.model.Medico;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer>{
    
    Optional<Medico> findByNome(String nome);
}
