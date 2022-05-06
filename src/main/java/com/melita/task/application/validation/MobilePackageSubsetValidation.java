package com.melita.task.application.validation;

import com.melita.task.domain.mobile.MobilePackage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class MobilePackageSubsetValidation implements ConstraintValidator<MobilePackageSubset, MobilePackage> {
    private MobilePackage[] subset;

    @Override
    public void initialize(MobilePackageSubset mobilePackageSubset) {
        this.subset = mobilePackageSubset.anyOf();
    }

    @Override
    public boolean isValid(MobilePackage value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
