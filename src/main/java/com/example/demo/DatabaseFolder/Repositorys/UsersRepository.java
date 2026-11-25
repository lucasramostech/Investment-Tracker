package com.example.demo.DatabaseFolder.Repositorys;

// Repository da table users
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.DatabaseFolder.Entitys.UsersTable;

public interface UsersRepository extends JpaRepository<UsersTable, Long> {
    Optional<UsersTable> findByUsername(String username);
    boolean existsByUsername(String username);
}
