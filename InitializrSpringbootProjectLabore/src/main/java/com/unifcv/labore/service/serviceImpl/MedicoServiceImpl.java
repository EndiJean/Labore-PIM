package com.unifcv.labore.service.serviceImpl;

import com.unifcv.labore.model.Medico;
import com.unifcv.labore.repository.MedicoRepository;
import com.unifcv.labore.service.MedicoService;
import com.unifcv.labore.service.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoServiceImpl implements MedicoService{
    
    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public Medico procurarPorId(Integer id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        return medico.orElseThrow(() -> new ObjectNotFoundException("ID " + id +" não encontrado! Infome um ID válido."));
    }
    
    @Override
    public List<Medico> ListarNomeLike(String nome) {
       return medicoRepository.findByNomeLike(nome +"%");
    }

    @Override
    public List<Medico> Listar() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico salvar(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public void atualizar(Integer id, Medico medico) {
        medicoRepository.findById(id).map( m -> {
            m.setNome(medico.getNome());
            m.setCpf(medico.getCpf());
            m.setDataNascimento(medico.getDataNascimento());
            m.setSexo(medico.getSexo());
            m.setSenha(medico.getSenha());
            return medicoRepository.save(m);
        });
    }

    @Override
    public void deletar(Integer id) {
        medicoRepository.deleteById(id);
    }
}
