package com.example.assignment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoginResponse {
    private String token;

    public static LoginResponse from(String token) {
        return LoginResponse.builder()
                .token(token)
                .build();
    }
}