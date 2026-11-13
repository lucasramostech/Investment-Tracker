package com.example.demo.Scheduleds;

// Imports agendamento
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;

import com.example.demo.ApiFolder.*;

@Component 
public class ScheduledTwelve {

    // Injeção
    private final TwelveDataRequest twelveRequest;
    

    // Lista twelve data
    @Value("${tickers}")
    private List<String> tickers;

    private int tickerIndex;
  
    // Construtor
    public ScheduledTwelve(TwelveDataRequest twelveRequest) {
        this.twelveRequest = twelveRequest;
    }

    // Agendamento pra consumo de api
    @Scheduled(fixedRate = 15000)

    // Método pra consumir a api da twelve Data
    public void mostrarDadosTwelve() {

        String ticker = tickers.get(tickerIndex);
        System.out.println("Consultando Twelve Data: " + ticker);
        twelveRequest.puxarDadosTwelve(ticker);

        tickerIndex = (tickerIndex + 1) % tickers.size();
    }
}
