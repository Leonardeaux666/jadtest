/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jadlog.atualizacaomonetaria.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author leonardo.souza
 */
@Entity
@Data
@Table(name = "intern_moeda_cotacao")
public class AtualizacaoMonetariaEntity implements Serializable {
    @Id
    @Column(name = "ID_INTER_MOEDA" )
    private Long id;
    private Double valor;
    private String dt;
    
}
