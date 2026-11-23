package com.example.demo.Services;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.DTO.RegisterRequest;
import com.example.demo.DatabaseFolder.UsersRepository;
import com.example.demo.DatabaseFolder.UsersTable;


// Service que vai salvar o users na table db
@Service
public class RegisterService {

    // Injeções
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final RegisterAutentication autentication;

    // Construtor
    public RegisterService(UsersRepository usersRepository,
                           PasswordEncoder passwordEncoder,
                           RegisterAutentication autentication) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.autentication = autentication;
    }

    // Função que valida e salva na table de users
    public void register(RegisterRequest request) {

        // 4 casos específicos que acontecem
        if (!autentication.emailValido(request.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email inválido");
        }

        if (!autentication.senhaValida(request.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha fraca");
        }

        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "As senhas não conferem");
        }

        if (usersRepository.existsByUsername(request.getUsername())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email já cadastrado");
        }

        // Criptografa a senha p/ segurança
        String hash = passwordEncoder.encode(request.getPassword());

        // Salva no banco de dados
        usersRepository.save(new UsersTable(request.getUsername(), hash));
    }
}