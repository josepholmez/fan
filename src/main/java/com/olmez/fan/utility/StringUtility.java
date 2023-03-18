package com.olmez.fan.utility;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtility {

    /**
     * It says it is null or no its length
     * 
     * @param str
     * @return {@code false} if its length is greater than 0
     */
    public static boolean isEmpty(String str) {
        return (str == null) || str.isEmpty();
    }

}
