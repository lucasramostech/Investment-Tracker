package com.example.demo.Services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.demo.DatabaseFolder.Ativo;
import com.example.demo.DatabaseFolder.Repository;


@Service
public class SalvarDados {

    // Injeção do repository
    private final Repository database;

    // Construtor
    public SalvarDados (Repository database) {
        this.database = database;
    }

    // Função simples que salva na table de cotações 
    public void salvarOuAtualizar(String ticker, BigDecimal preco) {
        Ativo ativo = database.findByTicker(ticker)
                .orElse(new Ativo());

        ativo.setTicker(ticker);
        ativo.setPrecoAtual(preco);

        database.save(ativo);
    }
    
}
