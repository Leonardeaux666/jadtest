package com.jadlog.atualizacaomonetaria.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jadlog.atualizacaomonetaria.entity.ConstCalcTarifAerea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author leonardo.souza
 */
@Repository
public interface ConstCalcTarifAereaRepository extends JpaRepository<ConstCalcTarifAerea, Long>{
    
}
