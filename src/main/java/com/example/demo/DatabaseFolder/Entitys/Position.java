package com.example.demo.DatabaseFolder.Entitys;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "positions",uniqueConstraints = @UniqueConstraint(columnNames = {"wallet_id", "ticker"}))
public class Position {

    // Table dos ativos de cada carteira

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticker", nullable = false)
    private String ticker;

    @Column(name = "quantity", nullable = false, precision = 24, scale = 8)
    private BigDecimal quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;

    protected Position() {
    }


    // Construtor padrão
    public Position(String ticker, BigDecimal quantity, Wallet wallet) {
        this.ticker = ticker;
        this.quantity = quantity;
        this.wallet = wallet;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public String getTicker() {
        return ticker;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Wallet getWallet() {
        return wallet;
    }
}