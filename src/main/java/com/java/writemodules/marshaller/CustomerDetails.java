package com.java.writemodules.marshaller;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerDetails implements DynamoDBTypeConverter<String, com.java.writemodules.model.CustomerDetails> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convert(com.java.writemodules.model.CustomerDetails customerDetails) {
        try {
            return mapper.writeValueAsString(customerDetails);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public com.java.writemodules.model.CustomerDetails unconvert(String s) {
        try {
            return mapper.readValue(s , com.java.writemodules.model.CustomerDetails.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
