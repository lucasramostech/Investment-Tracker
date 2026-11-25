package com.example.demo.Services;

import org.springframework.stereotype.Component;


// Validador de emails e senhas
@Component
public class RegisterAutentication {

    // Email: texto + @ + texto + .com (aceita .com.br)
    private static final String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+\\.com(\\.br)?$";

    // Senha: 8+ caracteres, 1 maiúscula, 1 número, 1 especial
    private static final String senhaRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$";

    // função verifica email is valid
    public boolean emailValido(String email) {
        if (email == null) return false;
        return email.matches(emailRegex);
    }

    // função verifica password is valid
    public boolean senhaValida(String senha) {
        if (senha == null) return false;
        return senha.matches(senhaRegex);
    }
}