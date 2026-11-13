package com.example.demo.Scheduleds;

// Imports agendamento
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.ApiFolder.*;

@Component 
public class ScheduledGecko {

    // Injeção
    private final CoinGeckoRequest coinRequest;

    // Construtor
    public ScheduledGecko(CoinGeckoRequest coinRequest) {
        this.coinRequest = coinRequest;
    }

    // Agendamento pra consumo de api
    @Scheduled(fixedRate = 15000)

    // Método pra consumir a api da CoinGecko
    public void mostrarDadosGecko() {
        System.out.println("Consultando CoinGecko");
        coinRequest.puxarDadosGecko();
    }
}
