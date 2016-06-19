package com.auction.rest.vaidators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import com.auction.rest.vaidators.impl.CanBidImpl;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

@Constraint(validatedBy = CanBidImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ METHOD, FIELD, PARAMETER })
@Documented
@ReportAsSingleViolation
public @interface CanBid {

    String message() default "Sorry!! You cannot bid on the Auction that is not LIVE";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
