package com.unifcv.labore.service;

import com.unifcv.labore.model.Clinica;
import java.util.List;
import java.util.Optional;

public interface ClinicaService {
    
    public Optional<Clinica> procurarPorId(Integer id);
    
    public Optional<Clinica> procurarPorNome(String nome);
    
    public List<Clinica> listar();
    
    public Clinica salvar(Clinica clinica);
    
    public void atualizar(Integer id, Clinica clinica);
    
    public void deletar(Integer id);
    
}