package com.unifcv.labore.service;

import com.unifcv.labore.model.Paciente;
import java.util.List;
import java.util.Optional;

public interface PacienteService {
    
    public Optional<Paciente> procurarPorId(Integer id);
    
    public Optional<Paciente> procurarPorNome(String nome);
    
    public List<Paciente> listar();
    
    public Paciente salvar(Paciente paciente);
    
    public void atualizar(Integer id, Paciente paciente);
    
    public void deletar(Integer id);
    
}
