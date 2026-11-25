package com.example.demo.DatabaseFolder.Entitys;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "wallets")
public class Wallet {

    // Table das carteiras de investimentos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // Dono da carteira 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UsersTable user;

    // Ativos da carteira
    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Position> positions = new ArrayList<>();

   
    protected Wallet() {
    }


    // Cnstrutor
    public Wallet(String name, UsersTable user) {
        this.name = name;
        this.user = user;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UsersTable getUser() {
        return user;
    }

    public void setUser(UsersTable user) {
        this.user = user;
    }

    public List<Position> getPositions() {
        return positions;
    }
}