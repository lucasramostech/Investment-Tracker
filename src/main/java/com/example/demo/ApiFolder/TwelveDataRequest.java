package com.example.demo.ApiFolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

@Component
public class TwelveDataRequest {

    // Secret API key
    @Value("${twelvedata.api.key}")
    private String apiKey;

    @Value("${tickers}")
    private String ticker;

    private final RestTemplate restTemplate = new RestTemplate();

    // Metodo que vai puxar os dados da API do twelve Data;
    public List<String> puxarDadosTwelve() {
        List<String> respostas = new ArrayList<>();

        // Tratamento de erros
        try {
            for (String acao : Arrays.asList(ticker.split(","))) {
                String url = String.format(
                    "https://api.twelvedata.com/price?symbol=%s&apikey=%s",
                    acao.trim().toUpperCase(),
                    this.apiKey
                );
                respostas.add(restTemplate.getForObject(url, String.class));
            }
            return respostas;
        } catch (RestClientException exception) {
            throw new IllegalStateException("Erro ao consultar a Twelve Data.", exception);
        } finally {
            System.out.println("Consulta à Twelve Data finalizada.");
        }
    }
}