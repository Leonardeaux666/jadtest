/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jadlog.atualizacaomonetaria.repository;

import com.jadlog.atualizacaomonetaria.entity.AtualizacaoMonetariaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author leonardo.souza
 */
@Repository
public interface AtualizacaoMonetariaRepository extends JpaRepository<AtualizacaoMonetariaEntity, Long>{
    
}
