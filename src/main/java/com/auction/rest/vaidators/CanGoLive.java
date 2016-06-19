package com.auction.rest.vaidators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import com.auction.rest.vaidators.impl.CanBidImpl;
import com.auction.rest.vaidators.impl.CanGoLiveImpl;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

@Constraint(validatedBy = CanGoLiveImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ METHOD, FIELD, PARAMETER })
@Documented
@ReportAsSingleViolation
public @interface CanGoLive {

    String message() default "Sorry!! The Auction is already LIVE";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
