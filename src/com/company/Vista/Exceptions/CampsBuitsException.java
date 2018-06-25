package com.company.Vista.Exceptions;

/**
 * Created by xavierromacastells on 2/8/17.
 */
public class CampsBuitsException extends Exception {

    public CampsBuitsException (String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
