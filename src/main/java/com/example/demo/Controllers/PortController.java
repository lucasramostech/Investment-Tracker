package com.example.demo.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import com.example.demo.DTO.*;


import com.example.demo.ApiFolder.*;

@RestController
public class PortController {

    // Primeiro endpoint (register)
    @GetMapping("/teste")
    public String teste() {
        System.out.println("Endpoint /teste chamado");
        return "API funcionando";
    }


}
