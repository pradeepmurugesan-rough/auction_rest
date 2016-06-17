package com.auction.rest.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonConvertor {

    public static <T> T jsonToObject(String json, Class<T> klass) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return (T) mapper.readValue(json, klass);
        } catch (IOException e) {
            e.printStackTrace();
            throw  e;
        }
    }
}
