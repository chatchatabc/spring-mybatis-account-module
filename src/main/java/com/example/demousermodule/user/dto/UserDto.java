package com.example.demousermodule.user.dto;

import com.example.demousermodule.user.validations.PasswordMatches;
import com.example.demousermodule.user.validations.ValidEmail;
import lombok.Data;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@PasswordMatches
@Data
public class UserDto {

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;
    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

}
