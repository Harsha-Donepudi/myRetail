package com.retail.myRetail.restservice;

import org.springframework.stereotype.Component;

@Component
public class HelperFunctions {
    public static boolean isLong(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Long d = Long.parseLong(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
