/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jadlog.atualizacaomonetaria.service;

<<<<<<< HEAD
import com.jadlog.atualizacaomonetaria.entity.AtualizacaoMonetariaEntity;
import com.jadlog.atualizacaomonetaria.repository.AtualizacaoMonetariaRepository;
=======
import com.jadlog.atualizacaomonetaria.entity.ConstCalcTarifAerea;
import com.jadlog.atualizacaomonetaria.entity.InternMoedaCotacao;
import com.jadlog.atualizacaomonetaria.entity.InternMoedaCotacaoPk;
>>>>>>> 74ab0f8 (Primeiro Commit)
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
<<<<<<< HEAD
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
=======
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.jadlog.atualizacaomonetaria.entity.InterMoeda;
import com.jadlog.atualizacaomonetaria.repository.AtualizacaoMonetariaRepository;
import com.jadlog.atualizacaomonetaria.repository.ConstCalcTarifAereaRepository;
import com.jadlog.atualizacaomonetaria.repository.InterMoedaRepository;
import com.jadlog.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
>>>>>>> 74ab0f8 (Primeiro Commit)
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

<<<<<<< HEAD
    @Autowired
    private AtualizacaoMonetariaRepository repository;
   
=======
    private final AtualizacaoMonetariaRepository repository;
    private final InterMoedaRepository interMoedaRepository;
    private final ConstCalcTarifAereaRepository constCalcTarifAereaRepository;

>>>>>>> 74ab0f8 (Primeiro Commit)
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
<<<<<<< HEAD
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
=======
        InternMoedaCotacao entityDolar = new InternMoedaCotacao();
        InternMoedaCotacaoPk id = new InternMoedaCotacaoPk(getInterMoeda(3L).getId(), formatDate());
        entityDolar.setInternMoedaCotacaoPk(id);
        entityDolar.setValor(dolar);
        repository.save(entityDolar);
    }
    
     public void saveDolarAereo(Double dolar){
        ConstCalcTarifAerea entityDolarAereo = new ConstCalcTarifAerea();
        InternMoedaCotacaoPk id = new InternMoedaCotacaoPk(getInterMoeda(2L).getId(), formatDate());
        entityDolarAereo.set(id);
        constCalcTarifAereaRepository.save(entityDolarAereo);
    }

    public void saveEuro(Double euro){
        InternMoedaCotacao entityEuro = new InternMoedaCotacao();
        InternMoedaCotacaoPk id = new InternMoedaCotacaoPk(getInterMoeda(2L).getId(), formatDate());
        entityEuro.setInternMoedaCotacaoPk(id);
        entityEuro.setValor(euro);
>>>>>>> 74ab0f8 (Primeiro Commit)
        repository.save(entityEuro);
    }
    public static String formatDate(){
        Date dataEuro = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dataFormatada = dateFormat.format(dataEuro);
        return dataFormatada;
    }
<<<<<<< HEAD
}
=======

    public InterMoeda getInterMoeda(Long id) {
        List<InterMoeda> interMoeda = interMoedaRepository.findAll();
        InterMoeda moeda = interMoeda.stream().filter(inter -> inter.getId() == id).findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Classe não encontrada"));
        return moeda;
    }
}
>>>>>>> 74ab0f8 (Primeiro Commit)
