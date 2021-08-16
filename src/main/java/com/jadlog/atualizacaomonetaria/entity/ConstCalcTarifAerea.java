package com.jadlog.atualizacaomonetaria.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author leonardo.souza
 */
@Entity
@Data
@Table(name = "const_calc_tarif_aerea", schema = "FRACTION")
public class ConstCalcTarifAerea {
    @Id
    @Column(name = "VAL_DOLAR")
    private Double valor;
    
    
}
