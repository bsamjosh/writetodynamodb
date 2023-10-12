package com.java.writemodules.util;

import com.java.writemodules.exceptions.KeyColumnNotPresentException;
import com.java.writemodules.model.WriteModel;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * Validates the key column and returns response entity for single workdetails save.
 */
@UtilityClass
@Slf4j
public class KeyColumnValidation {

    /**
     * Validate key is a base method , which validated key , sort and shipping details. throws response entity for column failure.
     * @param writeModel
     */
    public static void validateKeyColumns(WriteModel writeModel){

        try {
            validateTableKey(writeModel);
            validateSortKey(writeModel);
            validateShippingDetails(writeModel);
        } catch (KeyColumnNotPresentException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Validates if key column is present in writemodel
     * @param writeModel
     * @throws KeyColumnNotPresentException
     */
    public static void validateTableKey(WriteModel writeModel) throws KeyColumnNotPresentException {
        if(StringChecks.validateIfEmptyAndEmpty(writeModel.getOrderNumber())){
            throw new KeyColumnNotPresentException("KeyColumn OrderNumber is blank");
        }
    }

    /**
     * Validates if sort key is present
     * @param writeModel
     * @throws KeyColumnNotPresentException
     */
    public static void validateSortKey(WriteModel writeModel) throws KeyColumnNotPresentException {
        if(StringChecks.validateIfEmptyAndEmpty(writeModel.getOrderDate())){
            throw new KeyColumnNotPresentException("SortKey - OrderDate not present");
        }
    }

    /**
     * Validates if shipping details are present.
     * @param writeModel
     * @throws KeyColumnNotPresentException
     */
    public static void validateShippingDetails(WriteModel writeModel) throws KeyColumnNotPresentException {
        if(writeModel.getShippingDetails().size() > 0) {
            if(StringChecks.validateIfEmptyAndEmpty(writeModel.getShippingDetails().get(0).getTrackingNumber())
                || StringChecks.validateIfEmptyAndEmpty(writeModel.getShippingDetails().get(0).getOrderStatus())
                || StringChecks.validateIfEmptyAndEmpty(writeModel.getShippingDetails().get(0).getSubOrder()) ){
                throw new KeyColumnNotPresentException("Shippingdetails is available, but tracking details are not present");
            }
        }else{
            throw new KeyColumnNotPresentException("Shippingdetails not available");
        }

    }
}
