/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grability.test.cubesumation.util;

import com.grability.test.cubesumation.exception.InvalidParameterException;

/**
 *
 * @author Frank
 */
public class Validate {

    public int isNumber(String str) throws InvalidParameterException {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            throw new InvalidParameterException("Parámetro de entrada invalido '" + str + "'", e);
        }
    }

}
