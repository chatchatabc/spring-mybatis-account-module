package com.example.demousermodule.user.entities;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
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
    private LocalDate dateCreated;
    private LocalDate lastLogin;

}
