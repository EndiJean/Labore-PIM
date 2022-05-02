package com.unifcv.labore.service;

import com.unifcv.labore.model.Clinica;
import java.util.List;

public interface ClinicaService {
    
    Clinica ProcurarPorId(Integer id);
    
    List<Clinica> Listar(Clinica clinica);
    
}
