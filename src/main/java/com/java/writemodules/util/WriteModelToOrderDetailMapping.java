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
    public List<OrderDetails> convertWriteModelToOrderDetail(WriteModel writeModel){
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        for (int i = 0 ; i < writeModel.getShippingDetails().size() ; i++){
            var orderDetails = OrderDetails.builder()
                    .orderNumber(writeModel.getShippingDetails().get(i).getSubOrder())
                    .orderDate(writeModel.getOrderDate())
                    .customerId(writeModel.getCustomerDetails().getCustomerId())
                    .customerDetails(writeModel.getCustomerDetails())
                    .shippingDetails(writeModel.getShippingDetails().get(i))
                    .productId(ListWork.splitProductIdFromProductDetails(writeModel.getProductDetails().get(i)))
                    .subOrderNumber(writeModel.getShippingDetails().get(i).getSubOrder())
                    .orderNumberReference(writeModel.getOrderNumber())
                    .build();
            orderDetailsList.add(orderDetails);
        }
        return orderDetailsList;
    }

    /**
     * converts the list of write Models to list of order details.
     * @param writeModel
     * @param numberOfProducts
     * @return List of Order details to save
     */

    public List<OrderDetails> convertWriteModelToOrderDetails(List<WriteModel> writeModel , int numberOfProducts){
        List<OrderDetails> orderDetails =  new ArrayList<>();;
        for(int i = 0 ; i < numberOfProducts ; i++){
            var orderDetailsList = convertWriteModelToOrderDetail(writeModel.get(i));
            orderDetails.addAll(orderDetailsList);
        }
        return orderDetails;
    }
}
