package com.unifcv.labore.service.serviceImpl;

import com.unifcv.labore.model.Medico;
import com.unifcv.labore.repository.MedicoRepository;
import com.unifcv.labore.service.MedicoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoServiceImpl implements MedicoService{
    
    @Autowired
    MedicoRepository medicoRespository;

    @Override
    public Optional<Medico> procurarPorId(Integer id) {
        return medicoRespository.findById(id);
    }

    @Override
    public Optional<Medico> procurarPorNome(String nome) {
        return medicoRespository.findByNome(nome);
    }

    @Override
    public List<Medico> Listar() {
        return medicoRespository.findAll();
    }

    @Override
    public Medico salvar(Medico medico) {
        return medicoRespository.save(medico);
    }

    @Override
    public void atualizar(Integer id, Medico medico) {
        medicoRespository.findById(id).map( m -> {
            m.setNome(medico.getNome());
            m.setCpf(medico.getCpf());
            m.setDataNascimento(medico.getDataNascimento());
            m.setSexo(medico.getSexo());
            m.setSenha(medico.getSenha());
            return medicoRespository.save(m);
        });
    }

    @Override
    public void deletar(Integer id) {
        medicoRespository.deleteById(id);
    }
    
}
