package com.example.demo.DatabaseFolder;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PositionRepository extends JpaRepository<Position, Long> {

    // Todos os ativos de uma carteira
    List<Position> findByWalletId(Long walletId);

    // O ativo de um ticker especifico dentro de uma carteira
    Optional<Position> findByWalletIdAndTicker(Long walletId, String ticker);
}