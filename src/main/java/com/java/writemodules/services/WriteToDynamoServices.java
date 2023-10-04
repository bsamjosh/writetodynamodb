package com.java.writemodules.services;

import com.java.writemodules.model.WriteModel;
import com.java.writemodules.util.DynamoDBConnection;
import com.java.writemodules.util.WriteModelToOrderDetailMapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriteToDynamoServices {

    public Object save (WriteModel writeModel){
        var orderDetails = WriteModelToOrderDetailMapping.convertWriteModelToOrderDetail(writeModel);
        var saveResult = DynamoDBConnection.save(orderDetails);
        return saveResult;
    }

    public Object saves (List<WriteModel> writeModels){

        return new Object();
    }
}
