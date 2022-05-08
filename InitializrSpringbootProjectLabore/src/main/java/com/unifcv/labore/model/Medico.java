package com.unifcv.labore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message="O campo Nome deve ser preenchido.")
    private String nome;

    @Column(name="cpf", length = 11, nullable = false)
    @NotEmpty(message="O campo CPF deve ser preenchido.")
    private String cpf;
    
    @Column(name = "data_nascimento", nullable = false)
    @NotEmpty(message="O campo Data de Nascimento deve ser preenchido.")
    private Integer dataNascimento;

    private Character sexo;

    @Column(nullable = false)
    @NotEmpty(message="O campo Senha deve ser preenchido.")
    private String senha;

}
