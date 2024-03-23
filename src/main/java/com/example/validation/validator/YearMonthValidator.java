package com.example.validation.validator;

import com.example.validation.annotation.PhoneNumber;
import com.example.validation.annotation.YearMonth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {
    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    // String: 입력받은 값이 들어감
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        var reValue = s + "01";
        var rePattern = pattern+"dd";

        try {
            LocalDate date = LocalDate.parse(reValue, DateTimeFormatter.ofPattern(rePattern));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
