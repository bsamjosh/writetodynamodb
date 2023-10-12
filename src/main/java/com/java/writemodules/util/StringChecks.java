package com.java.writemodules.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringChecks {

    public boolean validateIfEmpty(String inString){
        return inString.isEmpty() || inString.isBlank();
    }

    public boolean validateIfNull(String inString){
        return inString == null || inString.equals(null);
    }

    public boolean validateIfEmptyAndEmpty(String inString){
        return validateIfEmpty(inString) || validateIfNull(inString);

    }
}
