package com.auction.rest.resources;



import com.auction.rest.dao.impl.user.UserDaoService;
import com.auction.rest.dao.utils.DaoUtils;
import com.auction.rest.model.Id;
import com.auction.rest.model.Item;
import com.auction.rest.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/user")

@Produces({ "application/json" })
@Api(description = "the user API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-06-15T16:19:02.945Z")
public class UserResource  {

    @GET


    @Produces({ "application/json" })
    @ApiOperation(value = "users list", notes = "", response = User.class, responseContainer = "List", tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "An array of users", response = User.class, responseContainer = "List"),
        @ApiResponse(code = 200, message = "Unexpected error", response = User.class, responseContainer = "List") })
    public Response userGet()
    throws NotFoundException {
        return null;
    }
    @GET
    @Path("/{id}")

    @Produces({ "application/json" })
    @ApiOperation(value = "Gets the details of the User", notes = "", response = User.class, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "user belongs to the id", response = User.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = User.class) })
    public Response userIdGet(
        @ApiParam(value = "id of the user to be retrieved",required=true) @PathParam("id") Long id)
    throws NotFoundException {
        UserDaoService userDaoService = DaoUtils.getUserService();
        User user = userDaoService.getUser(id);
        return Response.ok().entity(user).build();
    }
    @POST


    @Produces({ "application/json" })
    @ApiOperation(value = "Create a new User", notes = "", response = User.class, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "User object", response = User.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = User.class) })
    public Response userPost(@ApiParam(value = "User to add" ,required=true) User user)
    throws NotFoundException {
        UserDaoService userDaoService = DaoUtils.getUserService();
        Long id = userDaoService.addUser(user);
        return Response.ok().entity(new Id(id)).build();
    }
}
