package com.example.demo.Services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.example.demo.DatabaseFolder.Entitys.Ativo;
import com.example.demo.DatabaseFolder.Repositorys.Repository;


@Service
public class SalvarDados {

    // Injeção do repository
    private final Repository database;

    // Construtor
    public SalvarDados (Repository database) {
        this.database = database;
    }

    // Função simples que salva na table de cotações de uma vez
    public void salvarOuAtualizar(Map<String, BigDecimal> cotacoes) {
        if (cotacoes == null || cotacoes.isEmpty()) {
            return;
        }

        // Monta a lista completa e atualiza o DB de uma vez só (em lotes)
        List<Ativo> ativos = new ArrayList<>();
        cotacoes.forEach((ticker, preco) -> {
            Ativo ativo = database.findByTicker(ticker)
                    .orElse(new Ativo());

            ativo.setTicker(ticker);
            ativo.setPrecoAtual(preco);

            ativos.add(ativo);
        });

        database.saveAll(ativos);
    }
}
