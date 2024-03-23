package com.example.validation.validator;

import com.example.validation.annotation.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

// PhoneNumber annotation을 검증하는데 String을 입력으로 받음
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    private String regexp;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();
    }

    // String: 입력받은 값이 들어감
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = Pattern.matches(regexp, s);

        return result;
    }
}
