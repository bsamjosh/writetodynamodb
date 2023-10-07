package com.java.writemodules.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringChecks {

    public static boolean validateIfEmpty(String inString){
        return inString.isEmpty() || inString.isBlank();
    }

    public static boolean validateIfNull(String inString){
        return inString == null || inString.equals(null);
    }

    public static boolean validateIfEmptyAndEmpty(String inString){
        return validateIfEmpty(inString) || validateIfNull(inString);

    }
}
