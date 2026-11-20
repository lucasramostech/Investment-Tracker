package com.example.demo.Services;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import com.example.demo.Services.SalvarDados;

@Component 
public class DadosLotes {

    // injeçção do file de salvar dados
    private final SalvarDados salvarDados;
    private final Map<String, BigDecimal> cotacoes = new HashMap<>();

    // Construtor
    public DadosLotes(SalvarDados salvarDados) {
        this.salvarDados = salvarDados;
    }


    // Função para criar o obj
    public Map<String, BigDecimal> Buffer(String ticker, BigDecimal cotacao) {
        if (ticker != null && cotacao != null) {
            cotacoes.put(ticker, cotacao);
        }
        return cotacoes;
    }

    private int contador = 0;

    // Função para chamar o salvar dados e salvar em lotes
    public void loteador(boolean op) {
        if (op) {
            contador++;
        }

        if (contador >= 3) {
            salvarDados.salvarOuAtualizar(cotacoes);
            cotacoes.clear();
            contador = 0;
        }
    }

    
}
