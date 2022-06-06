package com.unifcv.labore.service.serviceImpl;

import com.unifcv.labore.model.Exame;
import com.unifcv.labore.repository.ExameRepository;
import com.unifcv.labore.service.ExameService;
import com.unifcv.labore.service.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExameServiceImpl implements ExameService {

    @Autowired
    ExameRepository exameRepository;

    @Override
    public Exame procurarPorId(Integer id) {
        Optional<Exame> exame = exameRepository.findById(id);
        return exame.orElseThrow(() -> new ObjectNotFoundException("ID " + id +" não encontrado! Infome um ID válido."));
    }
    
    @Override
    public List<Exame> ListarTipoExameLike(String tipoExame) {
       return exameRepository.findByTipoExameLike(tipoExame +"%");
    }

    @Override
    public List<Exame> listar() {
        return exameRepository.findAll();
    }

    @Override
    public Exame salvar(Exame exame) {
        return exameRepository.save(exame);
    }

    @Override
    public void atualizar(Integer id, Exame exame) {
        exameRepository.findById(id).map(e -> {
            e.setTipoExame(exame.getTipoExame());
            e.setDescricao(exame.getDescricao());
            return exameRepository.save(e);
        });
    }

    @Override
    public void deletar(Integer id) {
        exameRepository.deleteById(id);
    }

}
