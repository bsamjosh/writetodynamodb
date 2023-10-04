package com.java.writemodules.controller;

import com.java.writemodules.model.WriteModel;
import com.java.writemodules.services.WriteToDynamoServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@Slf4j
public class WriteToDynamoController {

    @Autowired
    WriteToDynamoServices writeToDynamoServices;

    @PostMapping(value = "/save")
    public ResponseEntity<Object> saveToDynamoDb(@RequestBody WriteModel writeModel){
        log.info("Received data to write to DB");
        return new ResponseEntity<>(writeToDynamoServices.save(writeModel), HttpStatus.OK);
    }

    @PostMapping(value = "/saves")
    public ResponseEntity<Object> savesToDynamoDb(@RequestBody List<WriteModel> writeModels){
        log.info("Received data to write to DB ");
        return new ResponseEntity<>(writeToDynamoServices.saves(writeModels), HttpStatus.OK);
    }

}
