package com.unifcv.labore.config;

import com.unifcv.labore.model.Anexo;
import com.unifcv.labore.model.Clinica;
import com.unifcv.labore.model.Exame;
import com.unifcv.labore.model.Geral;
import com.unifcv.labore.model.Medico;
import com.unifcv.labore.model.Paciente;
import com.unifcv.labore.repository.AnexoRepository;
import com.unifcv.labore.repository.ClinicaRepository;
import com.unifcv.labore.repository.ExameRepository;
import com.unifcv.labore.repository.GeralRepository;
import com.unifcv.labore.repository.MedicoRepository;
import com.unifcv.labore.repository.PacienteRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class LocalConfig {

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private GeralRepository geralRepository;

    @Autowired
    private AnexoRepository anexoRepostiroy;

    @Bean
    public void startDB() {
        Exame e1 = new Exame(null, "TIPO-1", "DESCRICAO-1");
        Paciente p1 = new Paciente(null, "PACIENTE-1", "111", "01/01/1111", 'M', "senha");
        Clinica c1 = new Clinica(null, "CLINICA-1", "1010", "ENDERECO-1");
        Medico m1 = new Medico(null, "MEDICO-1", "36002992049", "01/01/1111", 'M', "senha");

        Anexo a1 = new Anexo(null, "PDF-1");
        Anexo a2 = new Anexo(null, "PDF-2");

        List<Anexo> listaAnexo = new ArrayList<>();

        listaAnexo.add(a1);
        listaAnexo.add(a2);

        Geral g1 = new Geral(null, LocalTime.now(), LocalDate.now(), "STATUS",
                e1, p1, c1, m1, listaAnexo
        );

        exameRepository.saveAll(List.of(e1));
        pacienteRepository.saveAll(List.of(p1));
        clinicaRepository.saveAll(List.of(c1));
        medicoRepository.saveAll(List.of(m1));
        anexoRepostiroy.saveAll(listaAnexo);
        geralRepository.saveAll(List.of(g1));
    }

}
