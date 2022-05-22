package com.unifcv.labore.service;

import com.unifcv.labore.model.Medico;
import java.util.List;
import java.util.Optional;

public interface MedicoService {
    
    public Medico procurarPorId(Integer id);
    
    public Medico procurarPorNome (String nome);
    
    public List<Medico> Listar();
    
    public Medico salvar(Medico medico);
    
    public void atualizar(Integer id, Medico medico);
    
    public void deletar(Integer id);
    
}
