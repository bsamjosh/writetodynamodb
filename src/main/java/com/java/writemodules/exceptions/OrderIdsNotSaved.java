package com.java.writemodules.exceptions;

import com.amazonaws.services.dynamodbv2.model.AmazonDynamoDBException;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
@Generated
public class OrderIdsNotSaved {

    @ExceptionHandler(value = AmazonDynamoDBException.class)
    public ResponseEntity<Object> GeneralException(OrderIdNotSavedExceptions exceptions){
        return new ResponseEntity<>("Order IDs : "+exceptions.getFailedOrderNumber()+" failed", HttpStatus.NOT_MODIFIED);
    }
}
