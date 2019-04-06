package com.example.bestever.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    public static String asString(Object object) throws JsonProcessingException {
        return new ObjectMapper()
                .writeValueAsString(object);
    }

    private JsonUtils() {

    }
}
