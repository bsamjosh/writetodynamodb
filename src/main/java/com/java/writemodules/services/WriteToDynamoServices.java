package com.java.writemodules.services;

import com.java.writemodules.model.OrderDetails;
import com.java.writemodules.model.ValidateKeyColumns;
import com.java.writemodules.model.WriteModel;
import com.java.writemodules.util.DynamoDBConnection;
import com.java.writemodules.util.KeyColumnValidation;
import com.java.writemodules.util.WriteModelToOrderDetailMapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriteToDynamoServices {

    public Object save (WriteModel writeModel){
        KeyColumnValidation.validateKeyColumns(writeModel);
        var orderDetails = WriteModelToOrderDetailMapping.convertWriteModelToOrderDetail(writeModel);
        List<OrderDetails> toSave = null;
        toSave.add(orderDetails);
        return DynamoDBConnection.saves(toSave);
    }

    public Object saves (List<WriteModel> writeModels){

        var orderDetails = WriteModelToOrderDetailMapping.
                                            convertWriteModelToOrderDetails(writeModels,writeModels.size());
        return DynamoDBConnection.saves(orderDetails);
    }
}
