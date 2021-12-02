package com.saerang.currencyconverter.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CurrencyIdValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface CurrencyId {
    String message() default "유효하지 않은 currencyId.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
