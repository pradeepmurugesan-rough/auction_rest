package com.auction.rest.resources;

import com.auction.rest.dao.impl.bid.BidDaoService;
import com.auction.rest.dao.utils.DaoUtils;
import com.auction.rest.impl.BidImpl;
import com.auction.rest.model.Bid;
import com.auction.rest.model.Id;
import com.auction.rest.vaidators.CanBid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
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
    @ApiOperation(value = "Create a new Bid", notes = "", response = Bid.class, tags={ "/bid" })
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Bid object", response = Bid.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Bid.class) }
    )
    public Response bidPost(@ApiParam(value = "Bid to add" ,required = true) @Valid @CanBid Bid bid)
            throws NotFoundException {
        BidDaoService bidDaoService = DaoUtils.getBidService();
        BidImpl bidImpl = new BidImpl(bidDaoService);
        Id id = bidImpl.addBid(bid);
        return Response.ok().entity(id).build();
    }

    @GET
    @Path("/{id}")

    @Produces({ "application/json" })
    @ApiOperation(value = "Gets the details of the Bid", notes = "", response = Bid.class, tags={ "/bid" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "user belongs to the id", response = Bid.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = Bid.class) })
    public Response userIdGet(
            @ApiParam(value = "id of the user to be retrieved",required=true) @PathParam("id") Long id)
            throws NotFoundException {
        BidDaoService bidDaoService = DaoUtils.getBidService();
        BidImpl bidImpl = new BidImpl(bidDaoService);
        Bid bid = bidImpl.getBid(id);
        return Response.ok().entity(bid).build();
    }
}
