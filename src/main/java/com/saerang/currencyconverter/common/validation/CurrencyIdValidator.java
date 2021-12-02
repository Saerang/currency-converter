package com.saerang.currencyconverter.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CurrencyIdValidator implements ConstraintValidator<CurrencyId, String> {

    @Override
    public void initialize(CurrencyId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        if (value.length() != 3) {
            addConstraintViolation(context, "currencyId는 3자리 입니다.");
            return false;
        }

        if (!value.matches("^[A-Z]+$")) {
            addConstraintViolation(context, "currencyId는 알파벳만 가능합니다.");

            return false;
        }

        return true;
    }

    private void addConstraintViolation(ConstraintValidatorContext context, String msg) {
        //기본 메시지 비활성화
        context.disableDefaultConstraintViolation();
        //새로운 메시지 추가
        context.buildConstraintViolationWithTemplate(msg).addConstraintViolation();
    }
}
