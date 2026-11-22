package com.example.demo.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ApiFolder.*;

@RestController
public class PortController {

    private final TwelveDataRequest twelveRequest;
    private final CoinGeckoRequest coinRequest;

    public PortController(TwelveDataRequest twelveRequest, CoinGeckoRequest coinRequest) {
        this.twelveRequest = twelveRequest;
        this.coinRequest = coinRequest;
    }

    // Primeiro Endpoint (register)
    @PostMapping("/register")
    public String registerUser() {
        String datas = "teste";

        return datas;
    }


}
