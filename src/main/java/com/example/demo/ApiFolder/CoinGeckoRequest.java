package com.example.demo.ApiFolder;


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
    public Object[] puxarDadosGecko(String ticker) {

        // Tratamento de erros
        try {
            String url = String.format(
                "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids=%s",
                tickersCrypto.trim().toLowerCase()
            );

            return restTemplate.getForObject(url, Object[].class);
        } catch (RestClientException exception) {
            throw new IllegalStateException("Erro ao consultar a Twelve Data.", exception);
        } finally {
            System.out.println("Consulta à Twelve Data finalizada.");
        }

    }


    
}
