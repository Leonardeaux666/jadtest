/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jadlog.atualizacaomonetaria.repository;

import com.jadlog.atualizacaomonetaria.entity.InterMoeda;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author leonardo.souza
 */
public interface InterMoedaRepository extends JpaRepository<InterMoeda, Long> {
    
}
