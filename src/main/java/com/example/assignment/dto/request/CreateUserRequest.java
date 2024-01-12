package com.example.assignment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    private String firstname;
    private String lastname;
    private String dateofbirth;
    private String gender;
    private String email;
    private String mobileno;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pin;
}
