/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jadlog.atualizacaomonetaria.service;

import com.jadlog.atualizacaomonetaria.entity.AtualizacaoMonetariaEntity;
import com.jadlog.atualizacaomonetaria.repository.AtualizacaoMonetariaRepository;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@NoArgsConstructor
@AllArgsConstructor
public class AtualizacaoMonetaria {

    @Autowired
    private AtualizacaoMonetariaRepository repository;
   
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
        AtualizacaoMonetariaEntity entityDolar = new AtualizacaoMonetariaEntity();
        entityDolar.setId(3L);
        entityDolar.setValor(dolar);
        entityDolar.setDt(formatDate());

        System.out.println(entityDolar.getId());
        System.out.println(entityDolar.getValor());
        System.out.println(entityDolar.getDt());
        repository.save(entityDolar);
    }
    public void saveEuro(Double euro){
        AtualizacaoMonetariaEntity entityEuro = new AtualizacaoMonetariaEntity();

        entityEuro.setId(2L);
        entityEuro.setValor(euro);
        entityEuro.setDt(formatDate());


        System.out.println(entityEuro.getId());
        System.out.println(entityEuro.getValor());
        System.out.println(entityEuro.getDt());
        repository.save(entityEuro);
    }
    public static String formatDate(){
        Date dataEuro = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dataFormatada = dateFormat.format(dataEuro);
        return dataFormatada;
    }
}
