package com.java.writemodules.model;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString
public class ValidateKeyColumns {
    String keyColumn;
    String sortColumn;
    String shippingDetails;
}
