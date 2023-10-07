package com.java.writemodules.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ProductDetails {
    List<String> productId;
    List<String> productDetails;
    List<BigDecimal> price;
    String subOrder;
}
