package com.example.assignment.dto.response;

import com.example.assignment.model.TokenStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ValidateTokenResponse {
    private String tokenStatus;

    public static ValidateTokenResponse from(TokenStatus tokenStatus) {
        return ValidateTokenResponse.builder()
                .tokenStatus(tokenStatus.name())
                .build();
    }
}
