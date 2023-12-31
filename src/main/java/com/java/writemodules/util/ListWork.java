package com.java.writemodules.util;

import com.java.writemodules.model.OrderDetails;
import com.java.writemodules.model.ProductDetails;
import com.java.writemodules.model.ShippingDetails;
import com.java.writemodules.model.WriteModel;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
@Slf4j
public class ListWork {

    /**
     * Get Product details to return purchased product details
     * @param productDetails
     * @return list of productid
     */
    public List<String> splitProductIdFromProductDetails(ProductDetails productDetails){
        return productDetails.getProductId();
    }

    /**
     * takes order details to get the order ID's which are going to be saved.
     * @param orderDetails
     * @return list of orderNumbers for given orderDetails
     */
    public List<String> getOrderIdForLogs(List<OrderDetails> orderDetails){
        List<String> orderNumbers = new ArrayList<>();
        for(int i = 0 ; i < orderDetails.size() ; i++){
            orderNumbers.add(orderDetails.get(i).getOrderNumber());
        }
        return orderNumbers;
    }

    /**
     * gets the write model and validate order number , order date and shipping details are present
     * @param writeModel
     * @return list of valid WriteModel which passed key , sort and valid shipping columns to be saved.
     */
    public List<WriteModel> filterKeyColumnToSave(List<WriteModel> writeModel){
        log.info("Checking key columns to filter data");
        List<WriteModel> toSave = writeModel.stream()
                .filter(writeModels ->
                    !StringChecks.validateIfEmptyAndEmpty(writeModels.getOrderNumber())
                            && !StringChecks.validateIfEmptyAndEmpty(writeModels.getOrderDate())
                            && !StringChecks.validateIfEmptyAndEmpty(writeModels.getShippingDetails().get(0).getOrderStatus())
                )
                .map(writeModels
                        -> {
                                List<ProductDetails> matchingProductDetails
                                    = returnMatchingListOfProductAndShippingDetails(writeModels.getShippingDetails(),writeModels.getProductDetails());
                                writeModels.setProductDetails(matchingProductDetails);
                                return writeModels;
                            })
                .collect(Collectors.toList());
        return toSave;
    }

    /**
     * return product details for shipping details suborder number matching and have same in both places
     * @param shippingDetails
     * @param productDetails
     * @return list of Product details
     */
    public  List<ProductDetails> returnMatchingListOfProductAndShippingDetails(List<ShippingDetails> shippingDetails , List<ProductDetails> productDetails){
        log.info("Using shipping list to filter product details ");
        Set<String> shippingDetailOrderNumber = shippingDetails.stream()
                .map(shippingDetail -> shippingDetail.getSubOrder())
                .collect(Collectors.toSet());

        return productDetails.stream()
                    .filter(productDetail ->
                            shippingDetailOrderNumber.contains(productDetail.getSubOrder()))
                    .collect(Collectors.toList());
    }
}
