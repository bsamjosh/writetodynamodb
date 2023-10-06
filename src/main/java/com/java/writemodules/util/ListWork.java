package com.java.writemodules.util;

import com.java.writemodules.model.OrderDetails;
import com.java.writemodules.model.ProductDetails;
import com.java.writemodules.model.WriteModel;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
@Slf4j
public class ListWork {

    /**
     * Get Product details to return purchased product details
     * @param productDetails
     * @return list of product details
     */
    public static List<String> splitProductIdFromDetails(ProductDetails productDetails){
        return productDetails.getProductDetails();
    }

    /**
     * takes order details to get the order ID's which are going to be saved.
     * @param orderDetails
     * @return list of order numbers
     */
    public static List<String> getOrderIdForLogs(List<OrderDetails> orderDetails){
        List<String> orderNumbers = null;
        for(int i = 0 ; i < orderDetails.size() ; i++){
            orderNumbers.add(orderDetails.get(i).getOrderNumber());
        }
        return orderNumbers;
    }

    /**
     * gets the write model and validate order number , order date and shipping details are present
     * @param writeModel
     * @return list of write models which passes condition to be saved.
     */
    public static List<WriteModel> filterKeyColumnToSave(List<WriteModel> writeModel){
        List<WriteModel> toSave = new ArrayList<>();
        log.info("Checking key columns to filter data");
        toSave = writeModel.stream()
                .filter(writeModels ->
                    !writeModels.getOrderNumber().isBlank() || !writeModels.getOrderDate().isBlank() || !writeModels.getShippingDetails().get(0).getOrderStatus().isBlank()
                ).collect(Collectors.toList());
        return toSave;
    }
}
