package com.example.assignment.model;

import com.example.assignment.dto.request.CreateUserRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String dateofbirth;
    private String gender;

    @Column(unique = true)
    private String email;

    private String mobileno;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pin;
    private String password;

    public static User create(CreateUserRequest request, String defaultPassword) {
        return User.builder()
            .firstname(request.getFirstname())
            .lastname(request.getLastname())
            .dateofbirth(request.getDateofbirth())
            .gender(request.getGender())
            .email(request.getEmail())
            .mobileno(request.getMobileno())
            .address(request.getAddress())
            .city(request.getCity())
            .state(request.getState())
            .country(request.getCountry())
            .pin(request.getPin())
            .password(defaultPassword).build();
    }
}

