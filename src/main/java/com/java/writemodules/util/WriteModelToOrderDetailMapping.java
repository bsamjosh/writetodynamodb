package com.java.writemodules.util;

import com.java.writemodules.model.OrderDetails;
import com.java.writemodules.model.WriteModel;

import java.util.List;

public class WriteModelToOrderDetailMapping {

    public static OrderDetails convertWriteModelToOrderDetail(WriteModel writeModel){

        return OrderDetails.builder()
                .orderNumber(writeModel.getOrderNumber())
                .orderDate(writeModel.getOrderDate())
                .customerId(writeModel.getCustomerDetails().getCustomerId())
                .customerDetails(writeModel.getCustomerDetails())
                .shippingDetails(writeModel.getShippingDetails().get(0))
                .productId(ListWork.splitProductIdFromDetails(writeModel.getProductDetails().get(0)))
                .build();
    }

    public static List<OrderDetails> convertWriteModelToOrderDetails(WriteModel writeModel , int numberOfProducts){

        List<OrderDetails> orderDetails = null;
        for(int i = 0 ; i < numberOfProducts ; i++){
            var orderDetail = OrderDetails.builder()
                    .orderNumber(writeModel.getOrderNumber())
                    .orderDate(writeModel.getOrderDate())
                    .customerId(writeModel.getCustomerDetails().getCustomerId())
                    .customerDetails(writeModel.getCustomerDetails())
                    .shippingDetails(writeModel.getShippingDetails().get(i))
                    .productId(writeModel.getProductDetails().get(i).getProductId())
                    .build();
            orderDetails.add(orderDetail);
        }
        return orderDetails;
    }
}
