package com.example.demo.DatabaseFolder.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.DatabaseFolder.Entitys.Wallet;

import java.util.List;
import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    // Todas as carteiras de um usuário
    List<Wallet> findByUserId(Long userId);

    // Busca uma carteira só se ela for daquele usuário
    Optional<Wallet> findByIdAndUserId(Long id, Long userId);
}