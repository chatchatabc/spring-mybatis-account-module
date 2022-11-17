package com.example.springmybatisaccountmodule.user.Application.dto;

import com.example.springmybatisaccountmodule.user.Domain.validations.PasswordMatches;
import com.example.springmybatisaccountmodule.user.Domain.validations.ValidEmail;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@PasswordMatches
@Data
public class UserRegisDto {

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
