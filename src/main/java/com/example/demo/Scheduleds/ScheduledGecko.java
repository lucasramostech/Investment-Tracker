package com.example.demo.Scheduleds;

// Imports agendamento
import java.math.BigDecimal;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.ApiFolder.*;
import com.example.demo.Services.Auth.BusinessRules.DadosLotes;

@Component 
public class ScheduledGecko {

    // Injeção
    private final CoinGeckoRequest coinRequest;
    private final DadosLotes dadosLotes;

    // Construtor
    public ScheduledGecko(CoinGeckoRequest coinRequest, DadosLotes dadosLotes) {
        this.coinRequest = coinRequest;
        this.dadosLotes = dadosLotes;
    }

    // Agendamento pra consumo de api
    @Scheduled(fixedRateString = "${market-data.fixed-rate-ms}")

    // Método pra consumir a api da CoinGecko
    public void mostrarDadosGecko() {
        System.out.println("Consultando CoinGecko");


        // Chamada da API com tratamento de erro
        try {
            Map<String, Map<String, Object>> cotacoes = coinRequest.puxarDadosGecko();

            cotacoes.forEach((ticker, valores) -> {
                Object valor = valores.get("usd");
                if (valor instanceof Number) {
                    BigDecimal preco = new BigDecimal(valor.toString());
                    dadosLotes.buffer(ticker, preco);
                }
            });
        } finally {
            System.out.println("Consulta da CoinGecko finalizada");
            dadosLotes.marcarCicloCompleto(DadosLotes.COIN_GECKO);
        }
    }
    
}
