package com.java.writemodules.util;

import com.java.writemodules.model.ValidateKeyColumns;
import com.java.writemodules.model.WriteModel;

public class KeyColumnValidation {

    public static Object validateKeyColumns(WriteModel writeModel){

        return ValidateKeyColumns.builder()
                .keyColumn(validateTableKey(writeModel))
                .sortColumn(validateSortKey(writeModel))
                .shippingDetails(validateShippingDetails(writeModel))
                .build();
    }

    public static String validateTableKey(WriteModel writeModel){
        if(!writeModel.getOrderNumber().isBlank() || writeModel.getOrderNumber() != null){
            return "true";
        }
        return "false";
    }

    public static String validateSortKey(WriteModel writeModel){
        if(!writeModel.getOrderDate().isBlank() || writeModel.getOrderDate() != null){
            return "true";
        }
        return "false";
    }

    public static String validateShippingDetails(WriteModel writeModel){
        if(writeModel.getShippingDetails().size() > 0 || writeModel.getShippingDetails().get(0).getOrderStatus() != null){
            return "true";
        }
        return "false";
    }
}
