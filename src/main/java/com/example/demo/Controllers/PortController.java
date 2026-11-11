package com.example.demo.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.ApiFolder.TwelveDataRequest;

@RestController
public class PortController {

    private final TwelveDataRequest twelveRequest;

    public PortController(TwelveDataRequest twelveRequest) {
        this.twelveRequest = twelveRequest;
    }

    // Get para ver o resultado da apia
    @GetMapping("/cotacao")
    public String buscarCotacao() {
        return twelveRequest.puxarDadosTwelve("AAPLS");
    }


}
