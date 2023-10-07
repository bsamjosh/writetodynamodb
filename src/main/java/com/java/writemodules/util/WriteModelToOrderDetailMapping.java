package com.java.writemodules.util;

import com.java.writemodules.model.OrderDetails;
import com.java.writemodules.model.WriteModel;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to convert write model to order details.
 */
@UtilityClass
public class WriteModelToOrderDetailMapping {

    /**
     * Take a single Order Details and returns a List of Order details for batch save to save.
     * @param writeModel
     * @return Order Details
     */
    public static List<OrderDetails> convertWriteModelToOrderDetail(WriteModel writeModel){

        var orderDetails = OrderDetails.builder()
                .orderNumber(writeModel.getOrderNumber())
                .orderDate(writeModel.getOrderDate())
                .customerId(writeModel.getCustomerDetails().getCustomerId())
                .customerDetails(writeModel.getCustomerDetails())
                .shippingDetails(writeModel.getShippingDetails().get(0))
                .productId(ListWork.splitProductIdFromProductDetails(writeModel.getProductDetails().get(0)))
                .subOrderNumber(writeModel.getProductDetails().get(0).getSubOrder())
                .build();

        List<OrderDetails> orderDetailsList = new ArrayList<>();
        orderDetailsList.add(orderDetails);

        return orderDetailsList;
    }

    /**
     * converts the list of write Models to list of order details.
     * @param writeModel
     * @param numberOfProducts
     * @return List of Order details to save
     */

    public static List<OrderDetails> convertWriteModelToOrderDetails(List<WriteModel> writeModel , int numberOfProducts){

        List<OrderDetails> orderDetails = null;
        for(int i = 0 ; i < numberOfProducts ; i++){
            var orderDetail = OrderDetails.builder()
                    .orderNumber(writeModel.get(i).getOrderNumber())
                    .orderDate(writeModel.get(i).getOrderDate())
                    .customerId(writeModel.get(i).getCustomerDetails().getCustomerId())
                    .customerDetails(writeModel.get(i).getCustomerDetails())
                    .shippingDetails(writeModel.get(i).getShippingDetails().get(i))
                    .productId(writeModel.get(i).getProductDetails().get(i).getProductId())
                    .subOrderNumber(writeModel.get(i).getProductDetails().get(i).getSubOrder())
                    .build();
            orderDetails.add(orderDetail);
        }
        return orderDetails;
    }
}
