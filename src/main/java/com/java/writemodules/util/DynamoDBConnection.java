package com.java.writemodules.util;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.java.writemodules.component.DynamoDbConnection;
import com.java.writemodules.exceptions.OrderIdNotSavedExceptions;
import com.java.writemodules.model.OrderDetails;
import com.java.writemodules.model.ResultModel;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * contains list of methods which are executed to do save , update and delete operations.
 * @author Sam Berchmans
 */

@UtilityClass
public class DynamoDBConnection {

    @Autowired
    static DynamoDbConnection dynamoDbConnection;

    /**
     * Pass save method for single entries ( deprecated for later    )
     * @param orderDetails
     * @return saves result
     */
    public static ResultModel save(OrderDetails orderDetails){
        String orderNumber = orderDetails.getOrderNumber();
        dynamoDbConnection.returnMapper().save(orderDetails);
        return ResultModel.builder()
                .resultValue("Order number - "+orderNumber+" : Added Successfully.")
                .build();
    }

    /**
     * Save for batch save. More orders are saved.
     * @param orderDetails
     * @return saves result
     */
    public static Object saves(List<OrderDetails> orderDetails){
        List<String> orderNumbers = ListWork.getOrderIdForLogs(orderDetails);
        List<DynamoDBMapper.FailedBatch> resultOrderIds = dynamoDbConnection.returnMapper().batchSave(orderDetails);
        if(resultOrderIds.size() > 0){
            return OrderIdNotSavedExceptions.builder()
                    .exceptionCaught(resultOrderIds.get(0).getException().toString())
                    .failedOrderNumber(resultOrderIds.get(0).getUnprocessedItems().toString())
                    .build();
        }else{
            return ResultModel.builder()
                    .resultValue("Order numbers - "+orderNumbers.toString()+" : Added Successfully.")
                    .build();
        }
    }
}
