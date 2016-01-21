package com.touragency.utils;

import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String> {

    private int min;

    public void initialize(ValidEmail validEmail) {
        min = validEmail.min();
    }

    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email.length() >= min && EmailValidator.getInstance(false).isValid(email);
    }
}