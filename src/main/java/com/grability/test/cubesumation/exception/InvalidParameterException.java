/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grability.test.cubesumation.exception;

/**
 *
 * @author Frank
 */
public class InvalidParameterException extends CubeException{
    
    public InvalidParameterException() {
    }
    
    public InvalidParameterException(String message) {
        super(message);
    }

    public InvalidParameterException(Throwable cause) {
        super(cause);
    }

    public InvalidParameterException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
