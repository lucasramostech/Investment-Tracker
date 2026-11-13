package com.example.demo.ApiFolder;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component 
public class BrapiRequest {

    // Token Privado
    @Value("${brapi.api.key}")
    private String apiKeyBrapi;


    // Tansformador de JSON -> obje java
    private final RestTemplate restTemplate = new RestTemplate();


    // Função que vai puxar os dados
    public Double puxarDadosBrapi(String ticker) {

        System.out.println("\n======================= BRAPI =======================");
        System.out.println("Ticker: " + ticker.trim().toUpperCase());

        // Tratamento de erros
        try {
            String url = String.format(
                "https://brapi.dev/api/quote/%s?token=%s",
                ticker.trim().toUpperCase(),
                this.apiKeyBrapi
            );

            // Transforma JSON -> obj Java
            Map<String, Object> resposta = restTemplate.getForObject(url, Map.class);

            List<Map<String, Object>> results =
                    (List<Map<String, Object>>) resposta.get("results");

            Double preco = ((Number) results.get(0).get("regularMarketPrice")).doubleValue();

            System.out.println("Preço: " + preco);
            return preco;
        } catch (RestClientException exception) {
            throw new IllegalStateException("Erro ao consultar a Brapi.", exception);
        } finally {
            System.out.println("======================================================\n");
        }

    }


    
}