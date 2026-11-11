package com.example.demo.Scheduleds;

// Imports agendamento
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.example.demo.ApiFolder.*;

@Component 
public class Scheduled {

    // Injeção
    private final CoinGeckoRequest coinRequest;
    private final TwelveDataRequest twelveRequest;

    // Lista twelve data
    @Value("${tickers}")
    private List<String> tickers;


    public Scheduled(CoinGeckoRequest coinRequest, TwelveDataRequest twelveRequest) {
        this.twelveRequest = twelveRequest;
        this.coinRequest = coinRequest;
    }

    // Método agendado
    Scheduled(fixedRate = 5000)
    public Object[] mostrarDados() {

        for (String ticker : tickers) {
            Object[] datas = {
                twelveRequest.puxarDadosTwelve(ticker),
                coinRequest.puxarDadosGecko()
            };

            return datas;
        }

        return new Object[0];
    }



    
}
