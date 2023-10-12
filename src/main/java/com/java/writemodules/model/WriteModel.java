package com.java.writemodules.model;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class WriteModel {
    String orderDate;
    String orderNumber;
    List<ProductDetails> productDetails;
    List<ShippingDetails> shippingDetails;
    CustomerDetails customerDetails;
}
