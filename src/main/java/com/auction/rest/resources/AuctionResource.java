package com.auction.rest.resources;


import com.auction.rest.dao.impl.auction.AuctionDaoService;
import com.auction.rest.dao.utils.DaoUtils;
import com.auction.rest.impl.AuctionImpl;
import com.auction.rest.model.Auction;
import com.auction.rest.model.Bid;
import com.auction.rest.vaidators.CanGoLive;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/auction")

@Produces({ "application/json" })
@Api(description = "the auction API")
public class AuctionResource  {

    @GET
    @Path("/{id}/bids")

    @Produces({ "application/json" })
    @ApiOperation(value = "Gets all the bids of the Auction", notes = "", response = Bid.class, responseContainer = "List", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "user belongs to the id", response = Bid.class, responseContainer = "List"),
            @ApiResponse(code = 200, message = "Unexpected error", response = Bid.class, responseContainer = "List") })
    public Response auctionIdBidsGet(
            @ApiParam(value = "identifier of the auction",required=true) @PathParam("id") Long id)
            throws NotFoundException {
        return Response.ok().entity("This is a magic").build();
    }

    @GET
    @Path("/{id}")

    @Produces({ "application/json" })
    @ApiOperation(value = "Gets the details of the Auction", notes = "", response = Auction.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "auction belongs to the id", response = Auction.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = Auction.class) })
    public Response auctionIdGet(
            @ApiParam(value = "id of the auction to be retrieved",required=true) @PathParam("id") Long id)
            throws NotFoundException {
        AuctionDaoService auctionDaoService = DaoUtils.getAuctionService();
        AuctionImpl auctionImpl = new AuctionImpl(auctionDaoService);
        return Response.ok().entity(auctionImpl.getAuction(id)).build();
    }

    @PUT
    @Path("/{id}/golive")

    @Produces({ "application/json" })
    @ApiOperation(value = "Makes the Auction go Live", notes = "", response = Auction.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "went live ", response = Auction.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = Auction.class) })
    public Response goLive(
            @ApiParam(value = "id of the auction to be made live",required=true) @PathParam("id") @CanGoLive Long id)
            throws NotFoundException {
        AuctionDaoService auctionDaoService = DaoUtils.getAuctionService();
        AuctionImpl auctionImpl = new AuctionImpl(auctionDaoService);
        return Response.ok().entity(auctionImpl.makeAuctionLive(id)).build();
    }

    @GET
    @Produces({ "application/json" })
    @ApiOperation(value = "Auctions", notes = "Returns the list of available Auctions ", response = Auction.class, responseContainer = "List", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "An array of Auctions", response = Auction.class, responseContainer = "List"),
            @ApiResponse(code = 200, message = "Unexpected error", response = Auction.class, responseContainer = "List") })
    public Response auctionsGet()
            throws NotFoundException {
        return Response.ok().entity("This is a magic").build();
    }

    @POST
    @Produces({ "application/json" })
    @ApiOperation(value = "", notes = "Creates a new Auction", response = Auction.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Auction object", response = Auction.class),
            @ApiResponse(code = 200, message = "unexpected error", response = Auction.class) })
    public Response auctionsPost(
            @ApiParam(value = "Auction to add" ,required=true) Auction auction) throws NotFoundException {
        AuctionDaoService auctionDaoService = DaoUtils.getAuctionService();
        AuctionImpl auctionImpl = new AuctionImpl(auctionDaoService);
        return Response.ok().entity(auctionImpl.addAuction(auction)).build();
    }
}
