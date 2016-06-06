/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grability.test.cubesumation.bf;

import com.grability.test.cubesumation.dao.CubeDao;
import com.grability.test.cubesumation.exception.CubeException;
import com.grability.test.cubesumation.to.RequestCube;
import com.grability.test.cubesumation.to.ResponseCube;
import com.grability.test.cubesumation.util.Validate;
import org.apache.log4j.Logger;
/**
 *
 * @author Frank
 */
public class CubeBf {
    
    private static final Logger logger = Logger.getLogger(CubeBf.class);

    public ResponseCube action(RequestCube requestCube) {
        if (logger.isDebugEnabled()) {
            logger.debug("Execute action");
        }
        Validate validate = new Validate();
        try {
            validate.validateOperation(requestCube);
            ResponseCube responseCube = new ResponseCube();
            switch (requestCube.getOperation()[0].toUpperCase()) {
                case "UPDATE":
                    responseCube = new CubeDao().UpdateCube(requestCube);
                    break;
                case "QUERY":
                    responseCube = new CubeDao().queryCube(requestCube);
                    break;
                default:
                    if (requestCube.getOperation().length == 2) {
                        responseCube = new CubeDao().createCube(requestCube);
                    } else {
                        responseCube = new ResponseCube(requestCube.getCube(), "Numeros de test " + validate.isNumber(requestCube.getOperation()[0]));
                    }
                    break;
            }
            return responseCube;
        } catch (CubeException e) {
            logger.error(e.getMessage(), e);
            return new ResponseCube(requestCube.getCube(), e.getMessage());
        }
    }

}
