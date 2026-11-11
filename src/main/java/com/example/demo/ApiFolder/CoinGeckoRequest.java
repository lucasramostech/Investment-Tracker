package com.example.demo.ApiFolder;


import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component 
public class CoinGeckoRequest {

    // Array de cryptos
    @Value("${tickersCrypto}")
    private String tickersCrypto;


    // Tansformador de JSON -> obje java
    private final RestTemplate restTemplate = new RestTemplate();

    // Função que vai puxar as cryptos
    public Map<String, Map<String, Double>> puxarDadosGecko() {

        // Tratamento de erros
        try {
            String url = String.format(
                "https://api.coingecko.com/api/v3/simple/price?ids=%s&vs_currencies=usd",
                tickersCrypto.trim().toLowerCase()
            );

            return restTemplate.getForObject(url, Map.class);
        } catch (RestClientException exception) {
            throw new IllegalStateException("Erro ao consultar a Twelve Data.", exception);
        } finally {
            System.out.println("Consulta à Twelve Data finalizada.");
        }

    }


    
}