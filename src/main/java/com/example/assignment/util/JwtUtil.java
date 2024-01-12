package com.example.assignment.util;


import com.example.assignment.model.TokenStatus;
import com.example.assignment.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateJwtToken(User user) {
//        long expirationTimeMillis = 60000;
        long expirationTimeMillis = 10000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTimeMillis);

        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("password", user.getPassword())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }

    public TokenStatus isTokenValid(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build().parseClaimsJws(token)
                .getBody();

            return TokenStatus.VALID;
        } catch (Exception e) {
            if (e instanceof io.jsonwebtoken.ExpiredJwtException) {
                return TokenStatus.EXPIRED;
            }
            return TokenStatus.INVALID;
        }
    }
}
