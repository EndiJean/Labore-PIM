package com.unifcv.labore.service;

import com.unifcv.labore.model.Clinica;
import com.unifcv.labore.repository.ClinicaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClinicaServiceImpl implements ClinicaService{

    @Autowired
    ClinicaRepository clinicaRepository;
    
    @Override
    @Transactional
    public Clinica ProcurarPorId(Integer id) {
        return clinicaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Clinica> Listar(Clinica clinica) {
        return clinicaRepository.findAll();
    }
    
}
