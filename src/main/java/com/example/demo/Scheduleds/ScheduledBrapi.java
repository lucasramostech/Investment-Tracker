package com.example.demo.Scheduleds;

// Imports agendamento
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;

import com.example.demo.ApiFolder.*;
import com.example.demo.Services.SalvarDados;

@Component 
public class ScheduledBrapi {

    // Injeção
    private final BrapiRequest brapiRequest;
    private final SalvarDados salvarDados;

    // Lista twelve data
    @Value("${tickersBr}")
    private List<String> tickersBr;

    private int tickerBrIndex;


    // Construtor
    public ScheduledBrapi(BrapiRequest brapiRequest, SalvarDados salvarDados) {
        this.brapiRequest = brapiRequest;
        this.salvarDados = salvarDados;
    }

    // Agendamento pra consumo de api
    @Scheduled(fixedRateString = "${market-data.fixed-rate-ms}")

    // Método para consumir um ticker da Brapi
    public void mostrarDados() {
        String tickerBr = tickersBr.get(tickerBrIndex);
        try {
            System.out.println("Consultando Brapi: " + tickerBr);
            salvarDados.salvarOuAtualizar(
                    tickerBr,
                    brapiRequest.puxarDadosBrapi(tickerBr)
            );
        } finally {
            tickerBrIndex = (tickerBrIndex + 1) % tickersBr.size();
        }
    }
}
