package com.unifcv.labore.config;

import com.unifcv.labore.model.Anexo;
import com.unifcv.labore.model.Clinica;
import com.unifcv.labore.model.Exame;
import com.unifcv.labore.model.Geral;
import com.unifcv.labore.model.Medico;
import com.unifcv.labore.model.Paciente;
import com.unifcv.labore.repository.GeralRepository;
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
    private GeralRepository geralRepository;
    
    @Bean
    public void startDB() {
        Anexo a1 = new Anexo(null, "PDF-1");
        Anexo a2 = new Anexo(null, "PDF-2");
        
        List<Anexo> listaAnexo = new ArrayList<>();
        
        listaAnexo.add(a1);
        //listaAnexo.add(a2);
        
        Geral g1 = new Geral(null, "11:11", "01/01/1111", "STATUS",
                new Exame(null, "TIPO-1", "DESCRICAO-1"),
                new Paciente(null, "PACIENTE-1", "111", "01/01/1111", 'M', "senha"),
                new Clinica(null, "CLINICA-1", "1010", "ENDERECO-1"),
                new Medico(null, "MEDICO-1", "36002992049", "01/01/1111", 'M', "senha"),
                new ArrayList<Anexo>(listaAnexo)
        );
        
        geralRepository.saveAll(List.of(g1));
    }
    
}
