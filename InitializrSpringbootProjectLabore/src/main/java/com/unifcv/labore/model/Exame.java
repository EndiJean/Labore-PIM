package com.unifcv.labore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_exame")
public class Exame {

    @Id
    @Column(name = "id_exame")
    private Integer id;

    @Column(name = "tipo_exame")
    private String tipoExame;

    @Column(name = "descricao")
    private String descricao;
}
