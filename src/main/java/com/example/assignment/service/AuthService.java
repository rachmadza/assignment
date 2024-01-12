package com.example.assignment.service;

import com.example.assignment.dto.request.LoginRequest;
import com.example.assignment.dto.request.ValidateTokenRequest;
import com.example.assignment.dto.response.LoginResponse;
import com.example.assignment.dto.response.ValidateTokenResponse;
import com.example.assignment.model.Token;
import com.example.assignment.model.TokenStatus;
import com.example.assignment.model.User;
import com.example.assignment.repository.TokenRepository;
import com.example.assignment.repository.UserRepository;
import com.example.assignment.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest request) throws Exception {
        try {
            User user = userRepository.findByEmail(request.getUsername());

            if (Objects.isNull(user)) {
                throw new Exception("Wrong username or password!");
            }

            if (!Objects.equals(request.getPassword(), user.getPassword())) {
                throw new Exception("Wrong username or password!");
            }

            Token userToken = tokenRepository.getByUsername(user.getEmail());
            if (!Objects.isNull(userToken)) {
                tokenRepository.delete(userToken);
            }

            String token = jwtUtil.generateJwtToken(user);
            Token newToken = tokenRepository.save(Token.create(token, user.getEmail()));

            return LoginResponse.from(newToken.getToken());

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public ValidateTokenResponse validateToken(ValidateTokenRequest request) throws Exception {
        try {
            Token userToken = tokenRepository.findByToken(request.getToken());

            if (Objects.isNull(userToken)) {
                return ValidateTokenResponse.from(TokenStatus.INVALID);
            }

            return ValidateTokenResponse.from(jwtUtil.isTokenValid(request.getToken()));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
