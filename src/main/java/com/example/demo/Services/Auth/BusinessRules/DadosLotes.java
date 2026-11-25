package com.example.demo.Services.Auth.BusinessRules;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;


// Fluxo -> Junta todas  as cotações no buffer e salva de uma vez no banco
@Component
public class DadosLotes {

    // Lista confirmação de presença
    public static final String TWELVE_DATA = "TWELVE_DATA";
    public static final String BRAPI = "BRAPI";
    public static final String COIN_GECKO = "COIN_GECKO";

    private final SalvarDados salvarDados;
    private final Map<String, BigDecimal> cotacoes = new HashMap<>();
    private final Set<String> fontesEsperadas = Set.of(TWELVE_DATA, BRAPI, COIN_GECKO);
    private final Set<String> fontesCompletadas = new HashSet<>();

    // Construtor
    public DadosLotes(SalvarDados salvarDados) {
        this.salvarDados = salvarDados;
    }

    // Método sincronizados 
    public synchronized void buffer(String ticker, BigDecimal cotacao) {
        if (ticker != null && cotacao != null) {
            cotacoes.put(ticker, cotacao);
        }
    }
    
    // Função que identifica o retorno das 3 apis
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

        // Snapshot para vizualizsr no terminal
        System.out.println("\n========== BUFFER PARA SALVAR ==========");
        cotacoes.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(cotacao ->
                        System.out.println(cotacao.getKey() + " = " + cotacao.getValue())
                );
        System.out.println("Total de ativos no buffer: " + cotacoes.size());
        System.out.println("=======================================\n");

        salvarDados.salvarOuAtualizar(cotacoes);
        cotacoes.clear();
        fontesCompletadas.clear();
    }
}
