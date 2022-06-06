package com.unifcv.labore.service.serviceImpl;

import com.unifcv.labore.model.Clinica;
import com.unifcv.labore.repository.ClinicaRepository;
import com.unifcv.labore.service.ClinicaService;
import com.unifcv.labore.service.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicaServiceImpl implements ClinicaService{

    @Autowired
    ClinicaRepository clinicaRepository;
    
    @Override
    public Clinica procurarPorId(Integer id) {
        Optional<Clinica> clinica = clinicaRepository.findById(id);
        return clinica.orElseThrow(() -> new ObjectNotFoundException("ID " + id +" não encontrado! Infome um ID válido."));
    }
    
    @Override
    public List<Clinica> ListarNomeLike(String nome) {
       return clinicaRepository.findByNomeLike(nome +"%");
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
