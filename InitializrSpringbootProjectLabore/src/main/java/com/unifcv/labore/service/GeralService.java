package com.unifcv.labore.service;

import com.unifcv.labore.model.Geral;
import java.util.List;
import java.util.Optional;

public interface GeralService {
    
    public Optional<Geral> ProcurarPorId(Integer id);
    
    public List<Geral> listar();

    public Geral salvar(Geral geral);

}
