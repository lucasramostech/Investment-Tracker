package com.example.demo.DatabaseFolder;

// Repository da table users
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersTable, Long> {
    Optional<UsersTable> findByUsername(String username);
    boolean existsByUsername(String username);
}
