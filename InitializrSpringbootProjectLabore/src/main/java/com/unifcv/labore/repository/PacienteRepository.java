package com.unifcv.labore.repository;

import com.unifcv.labore.model.Paciente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    
    @Query("select p from Paciente p where p.cpf like :cpf")
    List<Paciente> findByCpfLike(@Param("cpf") String cpf);
    
}
