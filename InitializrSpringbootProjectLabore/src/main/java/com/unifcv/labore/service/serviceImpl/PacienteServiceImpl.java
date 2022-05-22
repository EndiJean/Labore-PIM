package com.unifcv.labore.service.serviceImpl;

import com.unifcv.labore.model.Paciente;
import com.unifcv.labore.repository.PacienteRepository;
import com.unifcv.labore.service.PacienteService;
import com.unifcv.labore.service.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    PacienteRepository pacienteRepository;
    
    @Override
    public Paciente procurarPorId(Integer id) {
         Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    @Override
    public Paciente procurarPorNome(String nome) {
        Optional<Paciente> paciente = pacienteRepository.findByNome(nome);
        return paciente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
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
