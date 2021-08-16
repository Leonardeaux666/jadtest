package com.jadlog.atualizacaomonetaria.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "INTERN_MOEDA", schema = "FRACTION")
public class InterMoeda {
    @Id
    @Column(name = "ID_INTERN_MOEDA")
    private Long id;
    private String codigo;
    private String nome;
    private String nomeIng;
    private String simbolo;
}