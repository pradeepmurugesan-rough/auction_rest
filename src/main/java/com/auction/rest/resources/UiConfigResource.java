package com.auction.rest.resources;

import com.auction.rest.impl.UiConfigImpl;
import com.auction.rest.model.Item;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
@Path("/uiconfig")

@Produces({ "application/json" })
public class UiConfigResource {
        @GET
        @Produces({ "application/json" })
        public Response getUiConfig() throws NotFoundException {
            UiConfigImpl uiConfig = new UiConfigImpl();
            return Response.ok().entity(uiConfig.getUiConfig()).build();
        }
}
