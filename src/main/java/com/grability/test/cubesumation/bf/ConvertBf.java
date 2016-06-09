/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grability.test.cubesumation.bf;

import com.grability.test.cubesumation.exception.InvalidParameterException;
import com.grability.test.cubesumation.to.CoordinateTo;
import com.grability.test.cubesumation.util.Validate;

/**
 *
 * @author Frank
 */
public class ConvertBf {

    public CoordinateTo toCoordinateTo(String xIn, String yIn, String zIn) throws InvalidParameterException {
        Validate validate = new Validate();
        return new CoordinateTo(validate.isNumber(xIn), validate.isNumber(yIn), validate.isNumber(zIn));
    }

}
