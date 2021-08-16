/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jadlog.atualizacaomonetaria.entity;

import java.io.Serializable;

import javax.persistence.*;
import lombok.Data;



/**
 *
 * @author leonardo.souza
 */
@Entity
@Data
@Table(name = "INTERN_MOEDA_COTACAO", schema = "FRACTION")
public class InternMoedaCotacao implements Serializable {
    @EmbeddedId
    private InternMoedaCotacaoPk internMoedaCotacaoPk;
    private Double valor;

}    
