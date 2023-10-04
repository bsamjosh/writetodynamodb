package com.java.writemodules.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class WriteModel {
    String orderDate;
    String orderNumber;
    List<ProductDetails> productDetails;
    List<ShippingDetails> shippingDetails;
    CustomerDetails customerDetails;
}
