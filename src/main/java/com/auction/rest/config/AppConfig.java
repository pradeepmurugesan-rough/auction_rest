package com.auction.rest.config;

import com.auction.rest.resources.AuctionResource;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public class AppConfig extends ResourceConfig {
    public AppConfig() {
        register(com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider.class);
        register(MultiPartFeature.class);
        packages(AuctionResource.class.getPackage().getName());
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
    }
}
