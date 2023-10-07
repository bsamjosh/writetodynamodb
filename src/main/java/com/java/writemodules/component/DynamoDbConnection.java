package com.java.writemodules.component;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DynamoDbConnection {

    @Value("${path.access}")
    public String access;

    @Value("${path.secret}")
    public String secret;

    @Bean
    public DynamoDBMapper returnMapper(){

        log.info("Key --> {} ",access);
        log.info("secret --> {} ",secret);
        AWSCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(
            new BasicAWSCredentials(access,secret));
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(credentialsProvider)
                .withRegion("us-east-1")
                .build();

        return new DynamoDBMapper(amazonDynamoDB);
    }
}
