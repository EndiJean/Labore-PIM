package com.unifcv.labore.repository;

import com.unifcv.labore.model.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer>{
    
}
