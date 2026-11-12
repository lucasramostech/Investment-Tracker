package com.example.demo.Scheduleds;

// Imports agendamento
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;

import com.example.demo.ApiFolder.*;

@Component 
public class ScheduledFile {

    // Injeção
    private final CoinGeckoRequest coinRequest;
    private final TwelveDataRequest twelveRequest;

    // Lista twelve data
    @Value("${tickers}")
    private List<String> tickers;

    private int tickerIndex;


    // Construtor
    public ScheduledFile(CoinGeckoRequest coinRequest, TwelveDataRequest twelveRequest) {
        this.twelveRequest = twelveRequest;
        this.coinRequest = coinRequest;
    }

    // Agendamento pra consumo de api
    @Scheduled(fixedRate = 15000)

    // Método pra consumir todas as APIS
    public Object[] mostrarDados() {
        List<Object> datas = new java.util.ArrayList<>();
        String ticker = tickers.get(tickerIndex);

        System.out.println("Consultando Twelve Data: " + ticker);
        datas.add(twelveRequest.puxarDadosTwelve(ticker));

        tickerIndex = (tickerIndex + 1) % tickers.size();

        if (tickerIndex == 0) {
            System.out.println("Consultando CoinGecko após atualizar todos os tickers.");
            datas.add(coinRequest.puxarDadosGecko());
        }

        return datas.toArray();
    }
}
