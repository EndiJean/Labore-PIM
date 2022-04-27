/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unifcv.labore.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_geral")
public class Geral {   
    
    @Id
    @Column(name = "id_geral")
    private Integer id;
    
    private Integer hora;
    
    @Column(name = "col_data")
    private Integer data;
    
    private String status;
    
    @OneToOne
    @JoinColumn(name = "id_exame")
    private Exame exame;
    
    @OneToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    
    @OneToOne
    @JoinColumn(name = "id_clinica")
    private Clinica clinica;
    
    @OneToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;
    
    @ManyToOne
    @JoinColumn(name="id_anexo")
    private List<Anexo> anexos;
}
