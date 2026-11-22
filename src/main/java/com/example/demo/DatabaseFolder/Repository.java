package com.example.demo.DatabaseFolder;

// Repository a table de cotacoes

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Ativo, Long> {
    Optional<Ativo> findByTicker(String ticker);
}
