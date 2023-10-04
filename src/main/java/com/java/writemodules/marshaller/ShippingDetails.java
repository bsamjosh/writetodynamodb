package com.java.writemodules.marshaller;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ShippingDetails implements DynamoDBTypeConverter<String, com.java.writemodules.model.ShippingDetails> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convert(com.java.writemodules.model.ShippingDetails shippingDetails) {
        try {
            return mapper.writeValueAsString(shippingDetails);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public com.java.writemodules.model.ShippingDetails unconvert(String s) {
        try {
            return mapper.readValue(s, com.java.writemodules.model.ShippingDetails.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
