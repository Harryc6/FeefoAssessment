package com.assessment.feefo.utils;

public class StringUtils {

    public static String getFormalStringFromCapitalizedSnakeCase(String s) {
        s = s.trim();
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase().replace("_", " ");
    }
}
