package com.milita.task.application.validation;

import com.milita.task.domain.Product;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AtLeastOneProductRequiredValidation implements ConstraintValidator<AtLeastOneProductRequired, Product> {

    @Override
    public boolean isValid(Product value, ConstraintValidatorContext context) {
        return (value.getInternetPackage() != null || value.getTvPackage() != null || value.getMobilePackage() != null || value.getTelephonyPackage() != null);
    }
}
