package com.unifcv.labore.service;

import com.unifcv.labore.model.Geral;
import java.util.List;
import java.util.Optional;

public interface GeralService {
    
    public Geral ProcurarPorId(Integer id);
    
    public List<Geral> listar();

    public Geral salvar(Geral geral);
    
    public void atualizar(Integer id, Geral geral);
    
    public void deletar(Integer id);
}
