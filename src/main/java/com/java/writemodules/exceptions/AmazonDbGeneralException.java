package com.java.writemodules.exceptions;

import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Generated
@Getter
@Setter
@Builder
public class AmazonDbGeneralException extends RuntimeException{
    String GeneralException;
}
