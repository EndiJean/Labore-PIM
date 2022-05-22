package com.unifcv.labore.service;

import com.unifcv.labore.model.Anexo;
import java.util.List;

public interface AnexoService {
    
    public Anexo procurarPorId(Integer id);
    
    public List<Anexo> listar();
    
    public Anexo salvar(Anexo anexo);
    
    public void atualizar(Integer id, Anexo anexo);
    
    public void deletar(Integer id);
}
