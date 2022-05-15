package com.unifcv.labore.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_geral")
public class Geral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_geral")
    private Integer id;

    private String hora;

    @Column(name = "col_data")
    private String data;

    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_exame")
    private Exame exame;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_clinica")
    private Clinica clinica;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_medico")
    private Medico medico;

    /*
    @OneToMany
    @JoinColumn(name = "id_anexo")
    private List<Anexo> anexos; 
    
   /*
    @ManyToOne
    @JoinColumn(name="id_anexo")
    private List<Anexo> anexos;
    */
    
}
