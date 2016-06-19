package com.auction.rest.exceptionmappers;

import com.auction.rest.model.Error;
import com.auction.rest.model.ErrorListItem;
import com.auction.rest.util.Constants;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Priority;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(6000)
public class ConstraintViolationMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(final ConstraintViolationException exception) {
        Error validationError = new Error();
        validationError.setMessage(Constants.VALIDATION_ERROR_MESSAGE);
        List<ErrorListItem> errors = new ArrayList<ErrorListItem>();
        for (ConstraintViolation violation :exception.getConstraintViolations()) {
            ErrorListItem error = new ErrorListItem();
            String invalidValue = ObjectUtils.defaultIfNull(violation.getInvalidValue(), "null").toString();
            error.setInvalidValue(invalidValue);
            error.setMessage(violation.getMessage());
            error.setPath(violation.getPropertyPath().toString());
            errors.add(error);
        }
        validationError.setDetails(errors);
        return Response
                .status(400)
                .entity(validationError)
                .build();
    }
}
