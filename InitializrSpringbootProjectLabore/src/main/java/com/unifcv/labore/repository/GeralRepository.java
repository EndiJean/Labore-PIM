package com.unifcv.labore.repository;

import com.unifcv.labore.model.Geral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeralRepository extends JpaRepository<Geral, Integer>{
}
