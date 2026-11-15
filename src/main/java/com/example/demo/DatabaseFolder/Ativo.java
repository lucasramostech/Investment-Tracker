package com.example.demo.DatabaseFolder;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "ativos")
public class Ativo {
    
    // Modelagem do banco de dados aqui

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticker", length = 10, nullable = false)
    private String ticker;

    @Column(name = "preco_atual", nullable = false, precision = 19, scale = 4)
    private BigDecimal precoAtual;

    
    public Ativo() {
    }

    // Construtor da table
    public Ativo(String ticker, BigDecimal precoAtual) {
        this.ticker = ticker;
        this.precoAtual = precoAtual;
    }

    // Getters e Setters
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getTicker() { 
        return ticker; 
    }
    
    public void setTicker(String ticker) { 
        this.ticker = ticker; 
    }

    public BigDecimal getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(BigDecimal precoAtual) {
        this.precoAtual = precoAtual;
    }
}