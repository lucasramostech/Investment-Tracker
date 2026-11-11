package com.example.demo.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.ApiFolder.*;;

@RestController
public class PortController {

    private final TwelveDataRequest twelveRequest;
    private final CoinGeckoRequest coinRequest;

    public PortController(TwelveDataRequest twelveRequest, CoinGeckoRequest coinRequest) {
        this.twelveRequest = twelveRequest;
        this.coinRequest = coinRequest;
    }

    // Get para ver o resultado da apia
    @GetMapping("/cotacao")
    public Object[] buscarCotacao() {
        Object[] datas = {
            twelveRequest.puxarDadosTwelve("AAPL"),
            coinRequest.puxarDadosGecko()
        };

        return datas;
    }


}
