package com.example.demo.ApiFolder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class TwelveDataRequest {

    // Secret API key
    @Value("${twelvedata.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    // Metodo que vai puxar os dados da API do twelve Data;
    public String puxarDadosTwelve(String ticker) {
        
        // Tratamento de erros
        try {
            String url = String.format(
                "https://api.twelvedata.com/price?symbol=%s&apikey=%s",
                ticker.trim().toUpperCase(),
                this.apiKey
            );

            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException exception) {
            throw new IllegalStateException("Erro ao consultar a Twelve Data.", exception);
        } finally {
            System.out.println("Consulta à Twelve Data finalizada.");
        }
    }
}