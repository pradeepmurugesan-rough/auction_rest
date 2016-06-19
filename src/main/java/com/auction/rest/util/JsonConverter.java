package com.auction.rest.util;

import com.auction.rest.exception.AuctionException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JsonConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonConverter.class);

    public static <T> T jsonToObject(String json, Class<T> klass) throws AuctionException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return (T) mapper.readValue(json, klass);
        } catch (IOException e) {
            LOGGER.error("Error while converting the json to object", e);
            throw new AuctionException(Constants.ExceptionMessage.JSON_CONVERSION_ERROR);
        }
    }

    public static <T> String objectToJson(T klass) throws AuctionException {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.disable(MapperFeature.USE_ANNOTATIONS);
            return mapper.writeValueAsString(klass);
        } catch (IOException e) {
            LOGGER.error("Error while converting the object to json string", e);
            throw new AuctionException(Constants.ExceptionMessage.JSON_CONVERSION_ERROR);
        }
    }
}
