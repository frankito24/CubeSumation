/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grability.test.cubesumation.bf;

import com.grability.test.cubesumation.dao.CubeDao;
import com.grability.test.cubesumation.exception.CubeException;
import com.grability.test.cubesumation.to.RequestCubeTo;
import com.grability.test.cubesumation.to.ResponseCubeTo;
import com.grability.test.cubesumation.util.Validate;
import org.apache.log4j.Logger;

/**
 *
 * @author Frank
 */
public class CubeBf {

    private static final Logger logger = Logger.getLogger(CubeBf.class);

    public ResponseCubeTo action(RequestCubeTo requestCube) {
        if (logger.isDebugEnabled()) {
            logger.debug("Execute action");
        }
        Validate validate = new Validate();
        try {
            this.validateOperation(requestCube);
            ResponseCubeTo responseCube = new ResponseCubeTo();
            switch (requestCube.getOperation()[0].toUpperCase()) {
                case "UPDATE":
                    this.validateCube(requestCube);
                    responseCube = new CubeDao().UpdateCube(requestCube);
                    break;
                case "QUERY":
                    this.validateCube(requestCube);
                    responseCube = new CubeDao().queryCube(requestCube);
                    break;
                default:
                    if (requestCube.getOperation().length == 2) {
                        responseCube = new CubeDao().createCube(requestCube);
                    } else {
                        responseCube = new ResponseCubeTo(requestCube.getCube(), "Números de test " + validate.isNumber(requestCube.getOperation()[0]));
                    }
                    break;
            }
            return responseCube;
        } catch (CubeException e) {
            logger.error(e.getMessage(), e);
            return new ResponseCubeTo(requestCube.getCube(), e.getMessage());
        }
    }

    public void validateOperation(RequestCubeTo requestCube) throws CubeException {
        int a = requestCube.getOperation().length;
        if (a != 1 && a != 2 && a != 5 && a != 7) {
            throw new CubeException("Operación no valida");
        }
    }
    
    public void validateCube(RequestCubeTo requestCube) throws CubeException {
        if (requestCube.getCube().getCube() == null) {
            throw new CubeException("Operación no valida, es necesario crear el cubo");
        }
    }

}
