package com.unifcv.labore.repository;

import com.unifcv.labore.model.Exame;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer>{
    
    @Query("select p from Exame p where p.tipoExame like :tipoExame")
    List<Exame> findByTipoExameLike(@Param("tipoExame") String tipoExame);
}
