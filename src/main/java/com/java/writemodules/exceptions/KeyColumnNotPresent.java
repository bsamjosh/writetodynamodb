package com.java.writemodules.exceptions;

import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
@Generated
public class KeyColumnNotPresent {

//    @ExceptionHandler(value = UnsupportedOperationException.class)
    @ExceptionHandler(value = CustomKeyColumnNotPresent.class)
    public ResponseEntity<Object> returnWhenKeyColumnIsAbsent(KeyColumnNotPresentException exception){
        return new ResponseEntity<>("Required Column - "+exception.getColumnName()+" not present in request",
                HttpStatus.BAD_REQUEST);
    }
}
