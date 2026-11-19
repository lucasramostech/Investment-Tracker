package com.example.demo.Scheduleds;

// Imports agendamento
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;

import com.example.demo.ApiFolder.*;
import com.example.demo.Services.SalvarDados;

@Component 
public class ScheduledTwelve {

    // Injeção
    private final TwelveDataRequest twelveRequest;
    private final SalvarDados salvarDados;
    

    // Lista twelve data
    @Value("${tickers}")
    private List<String> tickers;

    private int tickerIndex;
  
    // Construtor  
    public ScheduledTwelve(TwelveDataRequest twelveRequest, SalvarDados salvarDados) {
        this.twelveRequest = twelveRequest;
        this.salvarDados = salvarDados;
    }
    // Just for while
    // Agendamento pra consumo de api
    @Scheduled(fixedRateString = "${market-data.fixed-rate-ms}")

    // Método pra consumir a api da twelve Data
    public void mostrarDadosTwelve() {

        String ticker = tickers.get(tickerIndex);
        try {
            System.out.println("Consultando Twelve Data: " + ticker);
            salvarDados.salvarOuAtualizar(
                    ticker,
                    twelveRequest.puxarDadosTwelve(ticker)
            );
        } finally {
            tickerIndex = (tickerIndex + 1) % tickers.size();
        }
    }
}
