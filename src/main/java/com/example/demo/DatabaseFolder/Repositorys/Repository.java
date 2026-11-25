package com.example.demo.DatabaseFolder.Repositorys;

// Repository a table de cotacoes

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.DatabaseFolder.Entitys.Ativo;

public interface Repository extends JpaRepository<Ativo, Long> {
    Optional<Ativo> findByTicker(String ticker);
}
