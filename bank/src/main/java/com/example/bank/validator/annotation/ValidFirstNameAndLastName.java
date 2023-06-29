package com.example.bank.validator.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = com.example.bank.validator.valid_classes.ValidFirstNameAndLastName.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFirstNameAndLastName {

    String message() default "Invalid first name or last name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
