package com.unifcv.labore.service;

import com.unifcv.labore.model.Exame;
import java.util.List;
import java.util.Optional;

public interface ExameService {
    
    public Exame procurarPorId(Integer id);
    
    public List<Exame> ListarTipoExameLike(String tipoExame);
    
    List<Exame> listar();
    
    Exame salvar(Exame exame);
    
    void atualizar(Integer id, Exame exame);
    
    void deletar(Integer id);
}
