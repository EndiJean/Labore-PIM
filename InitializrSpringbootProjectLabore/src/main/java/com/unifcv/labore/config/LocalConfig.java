package com.unifcv.labore.config;

import com.unifcv.labore.model.Anexo;
import com.unifcv.labore.model.Clinica;
import com.unifcv.labore.model.Exame;
import com.unifcv.labore.model.Geral;
import com.unifcv.labore.model.Medico;
import com.unifcv.labore.model.Paciente;
import com.unifcv.labore.repository.ClinicaRepository;
import com.unifcv.labore.repository.ExameRepository;
import com.unifcv.labore.repository.GeralRepository;
import com.unifcv.labore.repository.MedicoRepository;
import com.unifcv.labore.repository.PacienteRepository;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class LocalConfig {
    
    //@Autowired
    //private AnexoRepository anexoRepository;
    
    @Autowired
    private ClinicaRepository clinicaRepository;
    
    @Autowired
    private ExameRepository exameRepository;
    
    @Autowired
    private GeralRepository geralRepository;
    
    @Autowired
    private MedicoRepository medicoRepository;
    
    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Bean
    public void startDB() {
        Clinica c1 = new Clinica(null, "CLINICA-1", "1010", "ENDERECO-1");
        Clinica c2 = new Clinica(null, "CLINICA-2", "2020", "ENDERECO-2");
        
        Medico m1 = new Medico(null, "MEDICO-1", "111", "01/01/1111", 'M', "senha");
        Medico m2 = new Medico(null, "MEDICO-2", "222", "02/02/2222", 'M', "senha");
        
        Paciente p1 = new Paciente(null, "PACIENTE-1", "111", "01/01/1111", 'M', "senha");
        Paciente p2 = new Paciente(null, "PACIENTE-2", "222", "02/02/2222", 'M', "senha");
        
        Exame e1 = new Exame(null, "TIPO-1", "DESCRICAO-1");
        Exame e2 = new Exame(null, "TIPO-2", "DESCRICAO-2");
        
        Geral g1 = new Geral(null, "11:11", "01/01/1111", "STATUS",
                new Exame(null, "TIPO-1", "DESCRICAO-1"),
                new Paciente(null, "PACIENTE-1", "111", "01/01/1111", 'M', "senha"),
                new Clinica(null, "CLINICA-1", "1010", "ENDERECO-1"),
                new Medico(null, "MEDICO-1", "111", "01/01/1111", 'M', "senha")
        );
        
        Geral g2 = new Geral(null, "11:11", "01/01/1111", "STATUS",
                e2, p2, c2, m2);
        
        //clinicaRepository.saveAll(List.of(c1, c2));
        //medicoRepository.saveAll(List.of(m1, m2));
        //pacienteRepository.saveAll(List.of(p1, p2));
        //exameRepository.saveAll(List.of(e1, e2));
        geralRepository.saveAll(List.of(g1, g2));
    }
    
}
