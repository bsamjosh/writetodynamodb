package com.java.writemodules.component;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.java.writemodules.component.DynamoDbConnection;
import com.java.writemodules.exceptions.OrderIdNotSavedExceptions;
import com.java.writemodules.model.OrderDetails;
import com.java.writemodules.model.ResultModel;
import com.java.writemodules.util.ListWork;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * contains list of methods which are executed to do save , update and delete operations.
 * @author Sam Berchmans
 */
@Component
@Slf4j
public class DynamoDBSave {

    @Autowired
    DynamoDbConnection dynamoDbConnection;

    /**
     * Pass save method for single entries ( deprecated for later    )
     * @param orderDetails
     * @return saves result
     */
    public ResultModel save(OrderDetails orderDetails){
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
    public Object saves(List<OrderDetails> orderDetails){
        List<String> orderNumbers = ListWork.getOrderIdForLogs(orderDetails);
        log.info("Order Numbers to process --> {} ",orderNumbers.toString());
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
