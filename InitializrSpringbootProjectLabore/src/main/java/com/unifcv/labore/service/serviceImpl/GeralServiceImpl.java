package com.unifcv.labore.service.serviceImpl;

import com.unifcv.labore.model.Geral;
import com.unifcv.labore.repository.GeralRepository;
import com.unifcv.labore.service.GeralService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeralServiceImpl implements GeralService{

    @Autowired
    GeralRepository geralRepository;
    
    @Override
    public Optional<Geral> ProcurarPorId(Integer id) {
        return geralRepository.findById(id);
    }
    
    @Override
    public List<Geral> listar() {
        return geralRepository.findAll();
    }

    @Override
    public Geral salvar(Geral geral) {
        return geralRepository.save(geral);
    }
    
}
