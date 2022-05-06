package com.milita.task.application.validation;

import com.milita.task.domain.tv.TVPackage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class TVPackageSubsetValidation implements ConstraintValidator<TVPackageSubset, TVPackage> {
    private TVPackage[] subset;

    @Override
    public void initialize(TVPackageSubset tvPackageSubset) {
        this.subset = tvPackageSubset.anyOf();
    }

    @Override
    public boolean isValid(TVPackage value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
