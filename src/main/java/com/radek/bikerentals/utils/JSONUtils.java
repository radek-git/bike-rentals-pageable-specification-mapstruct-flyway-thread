package com.radek.bikerentals.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JSONUtils {

    private JSONUtils() {
    }

    public static String toJsonString(Object object, boolean isPretty) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        if (isPretty) {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } else {
            return objectMapper.writeValueAsString(object);
        }
    }
}
