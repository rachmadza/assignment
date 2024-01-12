package com.example.assignment.repository;

import com.example.assignment.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {

    Token findByToken(String token);

    Token getByUsername(String username);
}
