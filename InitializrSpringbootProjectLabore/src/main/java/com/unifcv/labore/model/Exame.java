package com.unifcv.labore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_exame")
public class Exame {

    @Id
    @Column(name = "id_exame")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_exame")
    private String tipoExame;

    @Column(name = "descricao")
    private String descricao;
    
    @OneToOne
    @JoinColumn(name = "id_anexo", referencedColumnName = "id_anexo")
    private Anexo anexo;
    
}
