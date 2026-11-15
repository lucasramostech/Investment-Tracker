package com.example.demo.ApiFolder;

import java.math.BigDecimal;
import java.util.Map;

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
    public BigDecimal puxarDadosTwelve(String ticker) {

        System.out.println("\n==================== TWELVE DATA ====================");
        System.out.println("Ticker: " + ticker.trim().toUpperCase());

        // Tratamento de erros
        try {
            String url = String.format(
                "https://api.twelvedata.com/price?symbol=%s&apikey=%s",
                ticker.trim().toUpperCase(),
                this.apiKey
            );

            Map<String, Object> resposta = restTemplate.getForObject(url, Map.class);
            Object valor = resposta.get("price");

            if (valor == null) {
                throw new IllegalStateException("A resposta da Twelve Data não contém o campo price.");
            }

            BigDecimal preco = new BigDecimal(valor.toString());
            System.out.println("Preço: " + preco);
            return preco;
        } catch (RestClientException exception) {
            throw new IllegalStateException("Erro ao consultar a Twelve Data.", exception);
        } finally {
            System.out.println("======================================================\n");
        }
    }
}