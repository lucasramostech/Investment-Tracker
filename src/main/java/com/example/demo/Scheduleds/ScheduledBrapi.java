package com.example.demo.Scheduleds;

// Imports agendamento
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;

import com.example.demo.ApiFolder.*;

@Component 
public class ScheduledBrapi {

    // Injeção
    private final BrapiRequest brapiRequest;

    // Lista twelve data
    @Value("${tickersBr}")
    private List<String> tickersBr;

    private int tickerBrIndex;


    // Construtor
    public ScheduledBrapi(BrapiRequest brapiRequest) {
        this.brapiRequest = brapiRequest;
    }

    // Agendamento pra consumo de api
    @Scheduled(fixedRate = 15000)

    // Método para consumir um ticker da Brapi
    public void mostrarDados() {
        String tickerBr = tickersBr.get(tickerBrIndex);
        System.out.println("Consultando Brapi: " + tickerBr);
        brapiRequest.puxarDadosBrapi(tickerBr);

        tickerBrIndex = (tickerBrIndex + 1) % tickersBr.size();
    }
}
