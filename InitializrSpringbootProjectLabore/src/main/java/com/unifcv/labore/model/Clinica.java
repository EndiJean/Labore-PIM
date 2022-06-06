package com.unifcv.labore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_clinica")
public class Clinica {
    
    @Id
    @Column(name = "id_clinica")
    private Integer id;

    @Column(name="nome")
    @NotEmpty(message = "Campo Nome é Obrigatório.")
    private String nome;

    @Column(name="cnpj")
    @NotEmpty(message = "Campo Cnpj é Obrigatório.")
    @CNPJ(message = "Informe um CNPJ válido.")
    private String cnpj;

    @Column(name="endereco")
    @NotEmpty(message = "Campo Endereço é Obrigatório.")
    private String endereco;
    
}
