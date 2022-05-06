package com.melita.task.application.validation;

import com.melita.task.domain.telephony.TelephonyPackage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class TelephonyPackageSubsetValidation implements ConstraintValidator<TelephonyPackageSubset, TelephonyPackage> {
    private TelephonyPackage[] subset;

    @Override
    public void initialize(TelephonyPackageSubset telephonyPackageSubset) {
        this.subset = telephonyPackageSubset.anyOf();
    }

    @Override
    public boolean isValid(TelephonyPackage value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
