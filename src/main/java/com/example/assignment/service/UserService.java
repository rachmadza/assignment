package com.example.assignment.service;

import com.example.assignment.dto.request.CreateUserRequest;
import com.example.assignment.model.User;
import com.example.assignment.repository.UserRepository;
import com.example.assignment.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${default.password}")
    private String defaultPassword;

    public User registerUser(CreateUserRequest request) throws Exception {
        try {
            User existingUser = userRepository.findByEmail(request.getEmail());

            if (!Objects.isNull(existingUser)) {
                throw new Exception("User already exists!");
            }

            return userRepository.save(User.create(request, defaultPassword));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public User getUser(Long id) throws Exception {
        try {
            return userRepository.findById(id).orElseThrow(() -> new Exception("User not found!"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
