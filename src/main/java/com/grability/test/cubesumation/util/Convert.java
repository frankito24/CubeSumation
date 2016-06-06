/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grability.test.cubesumation.util;

import com.grability.test.cubesumation.exception.InvalidParameterException;
import com.grability.test.cubesumation.to.CoordinateTo;

/**
 *
 * @author Frank
 */
public class Convert {
    
    public CoordinateTo toCoordinateTo(String xIn, String yIn, String zIn) throws InvalidParameterException{
        Validate validate = new Validate();
        int x = validate.isNumber(xIn);
        int y = validate.isNumber(yIn);
        int z = validate.isNumber(zIn);
    return new CoordinateTo(x, y, z);
    }
    
}
