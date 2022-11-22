package com.example.user.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;
    private String username;
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    @ElementCollection
    private List<String> roles;
    private LocalDate dateCreated;
    private LocalDate lastLogin;

}
