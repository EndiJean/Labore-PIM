package com.unifcv.labore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_anexo")
public class Anexo {
    
    @Id
    @Column(name = "id_anexo")
    private Integer id;

    @Column(name = "col_link")
    private String link;
    
}
