package com.example.demo.Controllers;

// imports
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import com.example.demo.DTO.*;
import com.example.demo.Services.RegisterService;


@RestController
public class PortController {

    private final RegisterService registerService;
  

    public PortController(RegisterService registerService) {
        this.registerService = registerService;
    }

    // Primeiro endpoint (register)
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterRequest request) {
        registerService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado");
    }


}
