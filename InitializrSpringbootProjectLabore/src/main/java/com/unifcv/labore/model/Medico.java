package com.unifcv.labore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_medico")
public class Medico {

    @Id
    @Column(name = "id_medico")
    private Integer id;

    private String nome;

    @Column(name="cpf", length = 11)
    private String cpf;

    @Column(name = "data_nascimento")
    private Integer dataNascimento;

    private Character sexo;

    private String senha;

}
