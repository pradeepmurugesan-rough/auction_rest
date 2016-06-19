package com.auction.rest.resources;

import com.auction.rest.dao.impl.bid.BidDaoService;
import com.auction.rest.dao.utils.DaoUtils;
import com.auction.rest.exception.AuctionException;
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
        @ApiResponse(code = 500, message = "Unexpected error", response = Error.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class, responseContainer = "List")})
    public Response addBid(@ApiParam(value = "Bid to add", required = true) @Valid @CanBid Bid bid)
            throws AuctionException {
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
            @ApiResponse(code = 200, message = "Bid belongs to the id", response = Bid.class),
            @ApiResponse(code = 500, message = "Unexpected error", response = Error.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class, responseContainer = "List")})
    public Response getBid(
            @ApiParam(value = "id of the bid to be retrieved", required=true) @PathParam("id") Long id)
            throws AuctionException {
        BidDaoService bidDaoService = DaoUtils.getBidService();
        BidImpl bidImpl = new BidImpl(bidDaoService);
        Bid bid = bidImpl.getBid(id);
        return Response.ok().entity(bid).build();
    }
}
