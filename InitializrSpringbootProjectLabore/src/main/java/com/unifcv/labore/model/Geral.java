package com.unifcv.labore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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

    @Column(name = "hora")
    private LocalTime hora;

    @Column(name = "col_data")
    private LocalDate data;

    @Column(name = "status")
    private String status;  

    @OneToOne
    @JoinColumn(name = "id_exame", referencedColumnName = "id_exame")
    private Exame exame;

    @OneToOne
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "id_clinica", referencedColumnName = "id_clinica")
    private Clinica clinica;

    @OneToOne
    @JoinColumn(name = "id_medico", referencedColumnName = "id_medico")
    private Medico medico;

    @OneToMany
    @JoinColumn(name = "id_geral", referencedColumnName = "id_geral")
    private List<Anexo> anexos = new ArrayList<>();     
}
