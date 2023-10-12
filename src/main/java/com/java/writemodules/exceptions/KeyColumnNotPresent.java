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

    @ExceptionHandler(value = KeyColumnNotPresentException.class)
    public ResponseEntity<Object> returnWhenKeyColumnIsAbsent(KeyColumnNotPresentException exception){
        return new ResponseEntity<>(exception.getMessage() + " " + HttpStatus.BAD_REQUEST ,
                HttpStatus.BAD_REQUEST);
    }
}
