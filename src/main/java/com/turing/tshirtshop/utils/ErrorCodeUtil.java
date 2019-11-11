package com.turing.tshirtshop.utils;

import java.util.HashMap;
import java.util.Map;

public class ErrorCodeUtil {

    private static Map<String,String> errorCodes = new HashMap<>();

    public static Map<String,String> getErrorCodes(){
        /*
        Authentication's Errors

         */

        errorCodes.put("Authorization code is empty","AUT_01");
        errorCodes.put("Access Unauthorized","AUT_02");

        /*
        Pagination's Errors

         */

        errorCodes.put("The order is not matched 'field,(DESC|ASC)","PAG_01");
        errorCodes.put("The field of order is not allow sorting","PAG_02");

        /*
        User's Errors
         */
        errorCodes.put("The email is invalid","USR_01");
        errorCodes.put("Password is invalid: must be between 5 and 10","USR_01");
        errorCodes.put("The field email is required","USR_02");
        errorCodes.put("The email is invalid","USR_03");
        errorCodes.put("The email already exists","USR_04");
        errorCodes.put("The email doesn't exist","USR_05");
        errorCodes.put("This is an invalid phone number","USR_06");
        errorCodes.put("This is too long","USR_07");
        errorCodes.put("This is an invalid Credit Card","USR_08");
        errorCodes.put("The Shipping Region ID is not number","USR_09");

        /*
        Category's Errors
         */
        errorCodes.put("Don't exist category with this ID","CAT_01");

        /*
        Department's Errors
         */
        errorCodes.put("The ID is not a number","DEP_01");
        errorCodes.put("Don'exist department with this ID","DEP_02");

        /*
        Customer's Error


         */
        errorCodes.put("Please provide a valid customer Id","CUST_01");
        errorCodes.put("Please write a review","CUST_02");
        errorCodes.put("rating must be between 1 and 5","CUST_03");

        return errorCodes;
    }
}
