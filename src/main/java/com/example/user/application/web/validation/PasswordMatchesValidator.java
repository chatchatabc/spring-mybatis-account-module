package com.example.user.application.web.validation;

import com.example.user.application.commons.vo.UserRegisVO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserRegisVO user = (UserRegisVO) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
