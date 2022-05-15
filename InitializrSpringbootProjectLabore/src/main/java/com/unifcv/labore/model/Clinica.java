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
@Table(name="tb_clinica")
public class Clinica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clinica", nullable = false)
    private Integer id;

    @Column( nullable = false)
    @NotEmpty(message="O campo Nome deve ser preenchido.")
    private String nome;

    @Column(name="cnpj", length = 25, nullable = false)
    @NotEmpty(message="O campo Cnpj deve ser preenchido.")
    private String cnpj;

    @Column( nullable = false)
    @NotEmpty(message="O campo Endereço deve ser preenchido.")
    private String endereco;
    
}
