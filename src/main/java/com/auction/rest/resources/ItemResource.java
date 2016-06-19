package com.auction.rest.resources;

import com.auction.rest.dao.impl.item.ItemDaoService;
import com.auction.rest.dao.utils.DaoUtils;
import com.auction.rest.impl.ItemImpl;
import com.auction.rest.model.Item;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/item")

@Produces({ "application/json" })
@Api(description = "the item API")
public class ItemResource  {


    @GET
    @Produces({ "application/json" })
    @ApiOperation(value = "Details of the Item", notes = "", response = Item.class, responseContainer = "List", tags={ "/item" })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "An array of items", response = Item.class, responseContainer = "List"),
        @ApiResponse(code = 200, message = "Unexpected error", response = Item.class, responseContainer = "List") })
    public Response getItems()
    throws NotFoundException {
        return null;
    }
    @GET
    @Path("/{id}")

    @Produces({ "application/json" })
    @ApiOperation(value = "Gets the details of the Item", notes = "", response = Item.class, tags={ "/item" })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "item belongs to the id", response = Item.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Item.class) })
    public Response getItem(
        @ApiParam(value = "id of the item to be retrieved",required=true) @PathParam("id") Long id)
    throws NotFoundException {
        ItemDaoService itemDaoService = DaoUtils.getItemService();
        ItemImpl impl = new ItemImpl(itemDaoService);
        return Response.ok().entity(impl.getItem(id)).build();
    }

    @POST
    @Produces({ "application/json" })
    @ApiOperation(value = "Create a new Item", notes = "", response = Item.class, tags={ "/item" })
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Item object", response = Item.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Item.class) })
    public Response addItem(@ApiParam(value = "Item to add" ,required=true) Item item)
    throws NotFoundException {
        ItemDaoService itemDaoService = DaoUtils.getItemService();
        ItemImpl impl = new ItemImpl(itemDaoService);
        return Response.ok().entity(impl.addItem(item)).build();
    }
}
