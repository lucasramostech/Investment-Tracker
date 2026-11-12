package com.example.demo.ApiFolder;


import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component 
public class BrapiRequest {

    // Array de cryptos
    @Value("${tickerBr}")
    private String tickersBr;

    // Token Privado
    @Value("${brapi.api.key}")
    private String apiKeyBrapi;


    // Tansformador de JSON -> obje java
    private final RestTemplate restTemplate = new RestTemplate();

    // Função que vai puxar as cryptos
    public String puxarDadosBrapi() {

        // Tratamento de erros
        try {
            String url = String.format(
                "https://brapi.dev/api/quote/%s?token=%s",
                tickersBr.trim().toUpperCase(),
                this.apiKeyBrapi
            );

            String resposta = restTemplate.getForObject(url, String.class);
            System.out.println("Resposta da Brapi: " + resposta);
            return resposta;
        } catch (RestClientException exception) {
            throw new IllegalStateException("Erro ao consultar a Brapi.", exception);
        } finally {
            System.out.println("Consulta à Brapi finalizada.");
        }

    }


    
}