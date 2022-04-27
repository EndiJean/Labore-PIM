package com.unifcv.labore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_paciente")
public class Paciente {
    
    @Id
    @Column(name = "id_paciente")
    private Integer id;

    private String nome;
    
    @Column(name="cpf", length = 11)
    private String cpf;
    
    @Column(name="data_nascimento")
    private Integer dataNascimeto;
    
    private Character sexo;
    
    private String senha;
    
}
