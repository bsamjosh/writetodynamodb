package com.java.writemodules.services;

import com.java.writemodules.model.OrderDetails;
import com.java.writemodules.model.WriteModel;
import com.java.writemodules.util.DynamoDBConnection;
import com.java.writemodules.util.KeyColumnValidation;
import com.java.writemodules.util.ListWork;
import com.java.writemodules.util.WriteModelToOrderDetailMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class which gets write Model , convert , validate and call save.
 */
@Service
public class WriteToDynamoServices {

    @Autowired
    DynamoDBConnection dynamoDBConnection;

    /**
     * Single to write data
     * @param writeModel
     * @return Object for Response entity
     */
    public Object save (WriteModel writeModel){
        KeyColumnValidation.validateKeyColumns(writeModel);
        var orderDetails = WriteModelToOrderDetailMapping.convertWriteModelToOrderDetail(writeModel);
        return dynamoDBConnection.saves(orderDetails);
    }

    /**
     * List of Write data.
     * @param writeModels
     * @return Object for Response entity
     */
    public Object saves (List<WriteModel> writeModels){

        var filterData = ListWork.filterKeyColumnToSave(writeModels);
        var orderDetails = WriteModelToOrderDetailMapping.
                                            convertWriteModelToOrderDetails(filterData,writeModels.size());
        return dynamoDBConnection.saves(orderDetails);
    }
}
