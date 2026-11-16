package com.example.demo.Scheduleds;

// Imports agendamento
import java.math.BigDecimal;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.ApiFolder.*;
import com.example.demo.Services.SalvarDados;

@Component 
public class ScheduledGecko {

    // Injeção
    private final CoinGeckoRequest coinRequest;
    private final SalvarDados salvarDados;

    // Construtor
    public ScheduledGecko(CoinGeckoRequest coinRequest, SalvarDados salvarDados) {
        this.coinRequest = coinRequest;
        this.salvarDados = salvarDados;
    }

    // Agendamento pra consumo de api
    @Scheduled(fixedRate = 30000)

    // Método pra consumir a api da CoinGecko
    public void mostrarDadosGecko() {
        System.out.println("Consultando CoinGecko");
        Map<String, Map<String, Object>> cotacoes = coinRequest.puxarDadosGecko();

        cotacoes.forEach((ticker, valores) -> {
            Object valor = valores.get("usd");
            if (valor instanceof Number) {
                BigDecimal preco = new BigDecimal(valor.toString());
                salvarDados.salvarOuAtualizar(ticker, preco);
            }
        });
    }
    
}
