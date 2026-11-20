package com.example.demo.Scheduleds;

// Imports agendamento
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;

import com.example.demo.ApiFolder.*;
import com.example.demo.Services.DadosLotes;

@Component 
public class ScheduledBrapi {

    // Injeção
    private final BrapiRequest brapiRequest;
    private final DadosLotes dadosLotes;

    // Lista twelve data
    @Value("${tickersBr}")
    private List<String> tickersBr;

    private int tickerBrIndex;


    // Construtor
    public ScheduledBrapi(BrapiRequest brapiRequest, DadosLotes dadosLotes) {
        this.brapiRequest = brapiRequest;
        this.dadosLotes = dadosLotes;
    }

    // Agendamento pra consumo de api
    @Scheduled(fixedRateString = "${market-data.fixed-rate-ms}")

    // Método para consumir um ticker da Brapi
    public void mostrarDados() {
        String tickerBr = tickersBr.get(tickerBrIndex);
        try {
            System.out.println("Consultando Brapi: " + tickerBr);
            dadosLotes.Buffer(
                    tickerBr,
                    brapiRequest.puxarDadosBrapi(tickerBr)
            );
        } finally {
            tickerBrIndex = (tickerBrIndex + 1) % tickersBr.size();

            // Chama o loteador
            dadosLotes.loteador(true);
        }
    }
}
