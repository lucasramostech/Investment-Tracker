package com.example.demo.Services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class DadosLotes {

    public static final String TWELVE_DATA = "TWELVE_DATA";
    public static final String BRAPI = "BRAPI";
    public static final String COIN_GECKO = "COIN_GECKO";

    private final SalvarDados salvarDados;
    private final Map<String, BigDecimal> cotacoes = new HashMap<>();
    private final Set<String> fontesEsperadas = Set.of(TWELVE_DATA, BRAPI, COIN_GECKO);
    private final Set<String> fontesCompletadas = new HashSet<>();

    public DadosLotes(SalvarDados salvarDados) {
        this.salvarDados = salvarDados;
    }

    public synchronized void buffer(String ticker, BigDecimal cotacao) {
        if (ticker != null && cotacao != null) {
            cotacoes.put(ticker, cotacao);
        }
    }

    public synchronized void marcarCicloCompleto(String fonte) {
        if (!fontesEsperadas.contains(fonte)) {
            return;
        }

        fontesCompletadas.add(fonte);
        if (!fontesCompletadas.containsAll(fontesEsperadas)) {
            return;
        }

        if (cotacoes.isEmpty()) {
            fontesCompletadas.clear();
            return;
        }

        salvarDados.salvarOuAtualizar(cotacoes);
        cotacoes.clear();
        fontesCompletadas.clear();
    }
}
