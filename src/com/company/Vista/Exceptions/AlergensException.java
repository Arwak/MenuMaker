package com.company.Vista.Exceptions;

/**
 * Created by xavierromacastells on 2/8/17.
 */
public class AlergensException extends Exception {

    public AlergensException (String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
