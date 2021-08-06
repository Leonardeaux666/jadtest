package com.jadlog;

import com.jadlog.atualizacaomonetaria.service.AtualizacaoMonetaria;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.xml.sax.SAXException;

@SpringBootApplication
public class AtualizacaoMonetariaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtualizacaoMonetariaApplication.class, args);
        AtualizacaoMonetaria atualizacao = new AtualizacaoMonetaria();
        try {
            atualizacao.atualizar();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AtualizacaoMonetariaApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(AtualizacaoMonetariaApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AtualizacaoMonetariaApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
