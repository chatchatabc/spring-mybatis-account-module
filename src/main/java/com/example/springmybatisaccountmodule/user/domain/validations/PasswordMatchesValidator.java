package com.example.springmybatisaccountmodule.user.Domain.validations;

import com.example.springmybatisaccountmodule.user.Application.dto.UserRegisDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserRegisDto user = (UserRegisDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
