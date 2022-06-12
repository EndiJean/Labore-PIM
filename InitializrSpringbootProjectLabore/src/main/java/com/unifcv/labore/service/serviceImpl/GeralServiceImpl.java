package com.unifcv.labore.service.serviceImpl;

import com.unifcv.labore.service.exceptions.ObjectNotFoundException;
import com.unifcv.labore.model.Geral;
import com.unifcv.labore.repository.GeralRepository;
import com.unifcv.labore.service.GeralService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeralServiceImpl implements GeralService{

    @Autowired
    GeralRepository geralRepository;
    
    @Override
    public Geral ProcurarPorId(Integer id) {
        Optional<Geral> geral = geralRepository.findById(id);
        return geral.orElseThrow(() -> new ObjectNotFoundException("ID " + id +" não encontrado! Infome um ID válido."));
    }
    
    @Override
    public List<Geral> listar() {
        return geralRepository.findAll();
    }

    @Override
    public Geral salvar(Geral geral) {
        geral.setHora(LocalTime.now());
        geral.setData(LocalDate.now());
        return geralRepository.save(geral);
    }
    
    @Override
    public void atualizar(Integer id, Geral geral) {
        geralRepository.findById(id).map( g -> {
            g.setHora(LocalTime.now());
            g.setData(LocalDate.now());
            g.setStatus(geral.getStatus());
            g.setExames(geral.getExames());
            g.setPaciente(geral.getPaciente());
            g.setClinica(geral.getClinica());
            g.setMedico(geral.getMedico());
            return geralRepository.save(g);
        });
    }

    @Override
    public void deletar(Integer id) {
        geralRepository.deleteById(id);
    }
}
