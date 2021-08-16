/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jadlog.atualizacaomonetaria.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 *
 * @author leonardo.souza
 */
@Embeddable
@Data
public class InternMoedaCotacaoPk implements Serializable {
    @Column(name = "ID_INTERN_MOEDA")
    private Long id;
    private String dt;

    public InternMoedaCotacaoPk() {
    }

    
    public InternMoedaCotacaoPk(Long id, String dt) {
        this.id = id;
        this.dt = dt;
    }
    
    
    
    
}
