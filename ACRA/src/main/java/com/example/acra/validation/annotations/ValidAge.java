package com.example.acra.validation.annotations;

import com.example.acra.validation.valid_classes.ValidAgeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidAgeValidator.class)
@Documented
public @interface ValidAge {
    String message() default "Age and birth date do not match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}