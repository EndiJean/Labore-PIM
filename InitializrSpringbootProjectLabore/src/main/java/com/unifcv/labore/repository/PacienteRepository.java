package com.unifcv.labore.repository;

import com.unifcv.labore.model.Paciente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    
    Optional<Paciente> findByNome(String nome);
    
}
