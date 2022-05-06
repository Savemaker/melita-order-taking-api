package com.milita.task.application.validation;

import com.milita.task.domain.internet.InternetPackage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class InternetPackageSubsetValidation implements ConstraintValidator<InternetPackageSubset, InternetPackage> {
    private InternetPackage[] subset;

    @Override
    public void initialize(InternetPackageSubset internetPackageSubset) {
        this.subset = internetPackageSubset.anyOf();
    }

    @Override
    public boolean isValid(InternetPackage value, ConstraintValidatorContext context) {
        if ( value == null || Arrays.asList(subset).contains(value)) {
            return true;
        } else {
            throw new InternetPackageException("Field internetPackage should be INTERNET_250_MBPS or INTERNET_1_GBPS");
        }
    }
}
