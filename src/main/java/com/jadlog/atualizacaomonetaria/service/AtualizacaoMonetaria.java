/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jadlog.atualizacaomonetaria.service;


import com.jadlog.atualizacaomonetaria.entity.ConstCalcTarifAerea;
import com.jadlog.atualizacaomonetaria.entity.InternMoedaCotacao;
import com.jadlog.atualizacaomonetaria.entity.InternMoedaCotacaoPk;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.jadlog.atualizacaomonetaria.entity.InterMoeda;
import com.jadlog.atualizacaomonetaria.repository.AtualizacaoMonetariaRepository;
import com.jadlog.atualizacaomonetaria.repository.ConstCalcTarifAereaRepository;
import com.jadlog.atualizacaomonetaria.repository.InterMoedaRepository;

import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author leonardo.souza
 */
@Service
@AllArgsConstructor
public class AtualizacaoMonetaria {


    private final AtualizacaoMonetariaRepository repository;
    private final InterMoedaRepository interMoedaRepository;
    private final ConstCalcTarifAereaRepository constCalcTarifAereaRepository;

 
    public void atualizar() throws ParserConfigurationException, SAXException, IOException{
                 
            DocumentBuilderFactory fabricaDolar = DocumentBuilderFactory.newInstance();
            DocumentBuilder builderDolar = fabricaDolar.newDocumentBuilder();
            Document docDolar = builderDolar.parse(new URL("https://www.fx-exchange.com/usd/rss.xml").openStream());
            
            NodeList listasDolar = docDolar.getElementsByTagName("description");
            Element ld = (Element) listasDolar.item(10);
            String listaDolar = ld.getTextContent();
           
            listaDolar = listaDolar
                    .replace("1 US Dollar = ","")
                    .replace(" Brazilian Real","");
                       
            DocumentBuilderFactory fabricaEuro = DocumentBuilderFactory.newInstance();
            DocumentBuilder builderEuro = fabricaEuro.newDocumentBuilder();
            Document docEuro = builderEuro.parse(new URL("https://www.fx-exchange.com/eur/rss.xml").openStream());
            
            NodeList listasEuro = docEuro.getElementsByTagName("description");
            Element le = (Element) listasEuro.item(10);
            String listaEuro = le.getTextContent();
           
            listaEuro = listaEuro
                    .replace("1 Euro = ","")
                    .replace(" Brazilian Real","");
                               
            Double dolar = convertToDouble(listaDolar);
            Double euro = convertToDouble(listaEuro);
            saveDolar(dolar);
            saveEuro(euro);
            
    }

    public static Double convertToDouble(String value) {
        Double valor = Double.parseDouble(value);
        return valor;     
    }
   
         
    public void saveDolar(Double dolar){

        InternMoedaCotacao entityDolar = new InternMoedaCotacao();
        InternMoedaCotacaoPk id = new InternMoedaCotacaoPk(getInterMoeda(3L).getId(), formatDate());
        entityDolar.setInternMoedaCotacaoPk(id);
        entityDolar.setValor(dolar);
        repository.save(entityDolar);
    }
    
     public void saveDolarAereo(Double dolar){
        ConstCalcTarifAerea entityDolarAereo = new ConstCalcTarifAerea();
        InternMoedaCotacaoPk id = new InternMoedaCotacaoPk(getInterMoeda(2L).getId(), formatDate());
        /*entityDolarAereo.set(id);*/
        constCalcTarifAereaRepository.save(entityDolarAereo);
    }

    public void saveEuro(Double euro){
        InternMoedaCotacao entityEuro = new InternMoedaCotacao();
        InternMoedaCotacaoPk id = new InternMoedaCotacaoPk(getInterMoeda(2L).getId(), formatDate());
        entityEuro.setInternMoedaCotacaoPk(id);
        entityEuro.setValor(euro);

        repository.save(entityEuro);
    }
    public static String formatDate(){
        Date dataEuro = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dataFormatada = dateFormat.format(dataEuro);
        return dataFormatada;
    }


    public InterMoeda getInterMoeda(Long id) {
        List<InterMoeda> interMoeda = interMoedaRepository.findAll();
        InterMoeda moeda = interMoeda.stream().filter(inter -> inter.getId() == id).findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Classe não encontrada"));
        return moeda;
    }
}

