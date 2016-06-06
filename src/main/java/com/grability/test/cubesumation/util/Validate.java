/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grability.test.cubesumation.util;

import com.grability.test.cubesumation.exception.CubeException;
import com.grability.test.cubesumation.exception.InvalidParameterException;
import com.grability.test.cubesumation.to.RequestCube;

/**
 *
 * @author Frank
 */
public class Validate {

    public int isNumber(String str) throws InvalidParameterException {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            throw new InvalidParameterException("Parámetro de entrada '" + str + "' debe ser numerico", e);
        }
    }

    public void validateOperation(RequestCube requestCube) throws CubeException {
        int a = requestCube.getOperation().length;
        if (a != 1 && a != 2 && a != 5 && a != 7) {
            throw new CubeException("Operacion no valida");
        }

    }

}
