package com.unifcv.labore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_medico")
public class Medico {

    @Id
    @Column(name = "id_medico")
    private Integer id;

    @Column(name = "nome")
    @NotEmpty(message = "Campo Nome é Obrigatório.")
    private String nome;

    @Column(name="cpf")
    @CPF(message = "Informe um CPF válido.")
    @NotEmpty(message = "Campo CPF é Obrigatório.")
    private String cpf;
    
    @Column(name = "data_nascimento")
    @NotEmpty(message = "Campo Data Nasc. é Obrigatório.")
    private String dataNascimento;

    @Column(name = "sexo")
    private char sexo;

    @Column(name = "senha")
    @NotEmpty(message = "Campo Senha é Obrigatório.")
    private String senha;
}
