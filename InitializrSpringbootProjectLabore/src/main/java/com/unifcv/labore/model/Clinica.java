package com.unifcv.labore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_clinica")
public class Clinica {
    
    @Id
    @Column(name = "id_clinica")
    private Integer id;

    private String nome;

    @Column(name="cnpj", length = 25)
    private String cnpj;

    private String endereco;
    
}
