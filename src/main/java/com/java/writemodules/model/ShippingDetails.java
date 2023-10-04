package com.java.writemodules.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ShippingDetails {
    int trackingNumber;
    String orderStatus;
}
