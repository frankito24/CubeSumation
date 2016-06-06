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
public class CubeException extends Exception{
    
    public CubeException() {
    }
    
    public CubeException(String message) {
        super(message);
    }

    public CubeException(Throwable cause) {
        super(cause);
    }

    public CubeException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
