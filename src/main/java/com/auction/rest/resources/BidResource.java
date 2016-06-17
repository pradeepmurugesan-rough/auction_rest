package com.auction.rest.resources;

import com.auction.rest.model.Bid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.core.Response;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/bid")
@Produces({ "application/json" })
@Api(description = "the bid API")
public class BidResource  {


    @POST
    @Produces({ "application/json" })
    @ApiOperation(value = "Create a new Bid", notes = "", response = Bid.class, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Bid object", response = Bid.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Bid.class) }
    )
    public Response bidPost(@ApiParam(value = "Bid to add" ,required = true) Bid bid) throws NotFoundException {
        return null;
    }
}
