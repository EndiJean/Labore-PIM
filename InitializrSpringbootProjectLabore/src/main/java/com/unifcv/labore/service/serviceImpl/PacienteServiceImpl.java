package com.unifcv.labore.service.serviceImpl;

import com.unifcv.labore.model.Paciente;
import com.unifcv.labore.repository.PacienteRepository;
import com.unifcv.labore.service.PacienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    PacienteRepository pacienteRepository;
    
    @Override
    public Optional<Paciente> procurarPorId(Integer id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Optional<Paciente> procurarPorNome(String nome) {
        return pacienteRepository.findByNome(nome);
    }

    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void atualizar(Integer id, Paciente paciente) {
        pacienteRepository.findById(id).map( p -> {
            p.setNome(paciente.getNome());
            p.setCpf(paciente.getCpf());
            p.setDataNascimeto(paciente.getDataNascimeto());
            p.setSexo(paciente.getSexo());
            p.setSenha(paciente.getSenha());
            return pacienteRepository.save(p);
        });
    }

    @Override
    public void deletar(Integer id) {
        pacienteRepository.deleteById(id);
    }
    
}
