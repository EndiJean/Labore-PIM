package com.unifcv.labore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_paciente")
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer id;

    @Column(nullable = false)
    private String nome;
    
    @Column(name="cpf", length = 11, nullable = false)
    private String cpf;
    
    @Column(name="data_nascimento")
    private Integer dataNascimeto;
    
    private Character sexo;
    
    @Column(nullable = false)
    private String senha;
    
}
