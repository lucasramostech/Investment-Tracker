package com.example.demo.DatabaseFolder;

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

    @Column(name = "preco_atual", nullable=false)
    private Double precoAtual;

    
    public Ativo() {
    }

    // Construtor da table
    public Ativo(String ticker, Double precoAtual) {
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

    public Double getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(Double precoAtual) {
        this.precoAtual = precoAtual;
    }
}