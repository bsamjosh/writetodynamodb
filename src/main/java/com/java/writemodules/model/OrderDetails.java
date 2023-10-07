package com.java.writemodules.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString
@DynamoDBTable(tableName = "OrderDetails")
public class OrderDetails {

    @DynamoDBHashKey(attributeName = "orderNumber")
    private String orderNumber;

    @DynamoDBAttribute(attributeName = "orderDate" )
    private String orderDate;

    @DynamoDBAttribute(attributeName = "customerId")
    private String customerId;

    @DynamoDBAttribute(attributeName = "customerDetails")
    @DynamoDBTypeConverted(converter = com.java.writemodules.marshaller.CustomerDetails.class)
    private CustomerDetails customerDetails;

    @DynamoDBAttribute(attributeName = "shippingDetails")
    @DynamoDBTypeConverted(converter = com.java.writemodules.marshaller.ShippingDetails.class)
    private ShippingDetails shippingDetails;

    @DynamoDBAttribute(attributeName = "productId")
    private List<String> productId;

    @DynamoDBIndexRangeKey(attributeName = "subOrderNumber" )
    @DynamoDBIndexHashKey(attributeName = "subOrderNumber" , globalSecondaryIndexName = "subOrderNumber-index")
    private String subOrderNumber;

}
