package com.example.springmybatisaccountmodule.user.domain.validations;

import com.example.springmybatisaccountmodule.user.application.dto.UserRegisDto;

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
