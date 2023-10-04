package com.java.writemodules.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString
public class CustomerDetails {
    String customerId;
    String customerName;
    int preferredCustomer;
    String address;
    String deliveryAddress;
    String addressIndicator;

}
