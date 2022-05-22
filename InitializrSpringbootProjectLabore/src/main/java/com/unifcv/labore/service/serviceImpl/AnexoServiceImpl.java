package com.unifcv.labore.service.serviceImpl;

import com.unifcv.labore.model.Anexo;
import com.unifcv.labore.repository.AnexoRepository;
import com.unifcv.labore.service.AnexoService;
import com.unifcv.labore.service.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnexoServiceImpl implements AnexoService{

    @Autowired
    AnexoRepository anexoRepository;
    
    @Override
    public Anexo procurarPorId(Integer id) {
        Optional<Anexo> anexo = anexoRepository.findById(id);
        return anexo.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    @Override
    public List<Anexo> listar() {
        return anexoRepository.findAll();
    }

    @Override
    public Anexo salvar(Anexo anexo) {
        return anexoRepository.save(anexo);
    }

    @Override
    public void atualizar(Integer id, Anexo anexo) {
        anexoRepository.findById(id).map( a -> {
            a.setLink(anexo.getLink());
            return anexoRepository.save(a);
        });
    }

    @Override
    public void deletar(Integer id) {
        anexoRepository.deleteById(id);
    }
    
}
