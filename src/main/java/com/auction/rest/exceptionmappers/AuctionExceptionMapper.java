package com.auction.rest.exceptionmappers;

import com.auction.rest.exception.AuctionException;
import com.auction.rest.model.Error;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class AuctionExceptionMapper implements ExceptionMapper<AuctionException> {

    @Override
    public Response toResponse(AuctionException exception) {
        Error error = new Error();
        error.setMessage(exception.getMessage());
        return Response.serverError().entity(error).build();
    }
}
