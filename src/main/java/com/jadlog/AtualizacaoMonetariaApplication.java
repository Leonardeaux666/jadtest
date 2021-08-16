package com.jadlog;

import com.jadlog.atualizacaomonetaria.repository.AtualizacaoMonetariaRepository;
import com.jadlog.atualizacaomonetaria.repository.ConstCalcTarifAereaRepository;
import com.jadlog.atualizacaomonetaria.repository.InterMoedaRepository;
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

    public static void main(String[] args) { SpringApplication.run(AtualizacaoMonetariaApplication.class, args); }

    @Bean
    CommandLineRunner init(AtualizacaoMonetariaRepository repository, InterMoedaRepository interMoedaRepository,ConstCalcTarifAereaRepository constCalcTarifAereaRepository ) {
        return args -> {
            initAtualizacao(repository, interMoedaRepository,constCalcTarifAereaRepository);
        };
    }

    private void initAtualizacao(AtualizacaoMonetariaRepository repository, InterMoedaRepository interMoedaRepository, ConstCalcTarifAereaRepository constCalcTarifAereaRepository)
            throws ParserConfigurationException, IOException, SAXException {
        AtualizacaoMonetaria atualizacao = new AtualizacaoMonetaria(repository,interMoedaRepository,constCalcTarifAereaRepository );
        atualizacao.atualizar();
    }

}
