package com.milita.task.application.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AtLeastOneProductRequiredValidation.class)
public @interface AtLeastOneProductRequired {
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "Please specify at least one product";
}
