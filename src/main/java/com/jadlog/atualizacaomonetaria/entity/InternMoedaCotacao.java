/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jadlog.atualizacaomonetaria.entity;

import java.io.Serializable;
<<<<<<< HEAD:src/main/java/com/jadlog/atualizacaomonetaria/entity/AtualizacaoMonetariaEntity.java
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
=======
import javax.persistence.*;

>>>>>>> 74ab0f8 (Primeiro Commit):src/main/java/com/jadlog/atualizacaomonetaria/entity/InternMoedaCotacao.java
import lombok.Data;

/**
 *
 * @author leonardo.souza
 */
@Entity
@Data
<<<<<<< HEAD:src/main/java/com/jadlog/atualizacaomonetaria/entity/AtualizacaoMonetariaEntity.java
@Table(name = "intern_moeda_cotacao")
public class AtualizacaoMonetariaEntity implements Serializable {
    @Id
    @Column(name = "ID_INTER_MOEDA" )
    private Long id;
    private Double valor;
    private String dt;
    
}
=======
@Table(name = "INTERN_MOEDA_COTACAO", schema = "FRACTION")
public class InternMoedaCotacao implements Serializable {
    @EmbeddedId
    private InternMoedaCotacaoPk internMoedaCotacaoPk;
    private Double valor;

}    
>>>>>>> 74ab0f8 (Primeiro Commit):src/main/java/com/jadlog/atualizacaomonetaria/entity/InternMoedaCotacao.java
