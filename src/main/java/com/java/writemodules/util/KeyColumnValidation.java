package com.java.writemodules.util;

import com.java.writemodules.exceptions.CustomKeyColumnNotPresent;
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
        } catch (CustomKeyColumnNotPresent e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Validates if key column is present in writemodel
     * @param writeModel
     * @throws CustomKeyColumnNotPresent
     */
    public static void validateTableKey(WriteModel writeModel) throws CustomKeyColumnNotPresent {
        if(!writeModel.getOrderNumber().isBlank() || writeModel.getOrderNumber() != null){
            log.info("Key Column present - {} ",writeModel.getOrderNumber());
        }else {
            throw new CustomKeyColumnNotPresent("Key Column is blank");
        }
    }

    /**
     * Validates if sort key is present
     * @param writeModel
     * @throws CustomKeyColumnNotPresent
     */
    public static void validateSortKey(WriteModel writeModel) throws CustomKeyColumnNotPresent {
        if(!writeModel.getOrderDate().isBlank() || writeModel.getOrderDate() != null){
            log.info("Sort key is present");
        }else{
            throw new CustomKeyColumnNotPresent("Sort Key not present");
        }
    }

    /**
     * Validates if shipping details are present.
     * @param writeModel
     * @throws CustomKeyColumnNotPresent
     */
    public static void validateShippingDetails(WriteModel writeModel) throws CustomKeyColumnNotPresent {
        if(writeModel.getShippingDetails().size() > 0 || writeModel.getShippingDetails().get(0).getOrderStatus() != null){
            log.info("Shipping details is present");
        } else{
            throw new CustomKeyColumnNotPresent("Shipping details not present");
        }
    }

}
