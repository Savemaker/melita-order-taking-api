package com.melita.task.application.validation;

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

    String message() default "Please specify at least one product. Available products: internetPackage={INTERNET_250_MBPS, INTERNET_1_GBPS}, mobilePackage={MOBILE_PREPAID, MOBILE_POSTPAID}, telephonyPackage={TELEPHONY_FREE_ON_NET_CALLS, TELEPHONY_UNLIMITED_CALLS}, tvPackage={TV_90_CHANNELS, TV_140_CHANNELS}";
}
