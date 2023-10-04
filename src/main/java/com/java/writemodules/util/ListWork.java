package com.java.writemodules.util;

import com.java.writemodules.model.OrderDetails;
import com.java.writemodules.model.ProductDetails;

import java.util.List;

public class ListWork {

    public static List<String> splitProductIdFromDetails(ProductDetails productDetails){
        return productDetails.getProductDetails();
    }

    public static List<String> getOrderIdForLogs(List<OrderDetails> orderDetails){
        List<String> orderNumbers = null;
        for(int i = 0 ; i < orderDetails.size() ; i++){
            orderNumbers.add(orderDetails.get(i).getOrderNumber());
        }
        return orderNumbers;
    }
}
