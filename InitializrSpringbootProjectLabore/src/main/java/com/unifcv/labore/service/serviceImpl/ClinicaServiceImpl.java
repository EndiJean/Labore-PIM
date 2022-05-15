package com.unifcv.labore.service.serviceImpl;

import com.unifcv.labore.model.Clinica;
import com.unifcv.labore.repository.ClinicaRepository;
import com.unifcv.labore.service.ClinicaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicaServiceImpl implements ClinicaService{

    @Autowired
    ClinicaRepository clinicaRepository;
    
    @Override
    public Optional<Clinica> procurarPorId(Integer id) {
        return clinicaRepository.findById(id);
    }
    
    @Override
    public Optional<Clinica> procurarPorNome(String nome) {
        return clinicaRepository.findByNome(nome);
    }

    @Override
    public List<Clinica> listar() {
        return clinicaRepository.findAll();
    }
    
    @Override
    public Clinica salvar(Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    @Override
    public void atualizar(Integer id, Clinica clinica) {
        clinicaRepository.findById(id).map( c -> {
            c.setNome(clinica.getNome());
            c.setCnpj(clinica.getCnpj());
            c.setEndereco(clinica.getEndereco());
            return clinicaRepository.save(c);
        });
    }

    @Override
    public void deletar(Integer id) {
        clinicaRepository.deleteById(id);
    }

}
