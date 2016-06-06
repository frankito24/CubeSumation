/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grability.test.cubesumation.dao;

import com.grability.test.cubesumation.exception.InvalidParameterException;
import com.grability.test.cubesumation.to.CoordinateTo;
import com.grability.test.cubesumation.to.CubeTo;
import com.grability.test.cubesumation.to.RequestCube;
import com.grability.test.cubesumation.to.ResponseCube;
import com.grability.test.cubesumation.util.Convert;
import com.grability.test.cubesumation.util.Validate;
import org.apache.log4j.Logger;

/**
 *
 * @author Frank
 */
public class CubeDao {
    
    private static final Logger logger = Logger.getLogger(CubeDao.class);

    public ResponseCube createCube(RequestCube requestCube) {
        if (logger.isDebugEnabled()) {
            logger.debug("Execute createCube");
        }
        try {
            return new ResponseCube(new CubeTo(new Convert().toCoordinateTo(requestCube.getOperation()[0], requestCube.getOperation()[0], requestCube.getOperation()[0])), "Cubo Creado restan " + new Validate().isNumber(requestCube.getOperation()[1]));
        } catch (InvalidParameterException e) {
            logger.error(e.getMessage(), e);
            return new ResponseCube(requestCube.getCube(), e.getMessage());
        }
    }

    public ResponseCube UpdateCube(RequestCube requestCube) {
        if (logger.isDebugEnabled()) {
            logger.debug("Execute UpdateCube");
        }
        try {
            requestCube.getCube().setCubeValue(new Convert().toCoordinateTo(requestCube.getOperation()[1], requestCube.getOperation()[2], requestCube.getOperation()[3]), new Validate().isNumber(requestCube.getOperation()[4]));
            return new ResponseCube(requestCube.getCube(), "Valor de la coordenada modificada correctamente");
        } catch (InvalidParameterException e) {
            logger.error(e.getMessage(), e);
            return new ResponseCube(requestCube.getCube(), e.getMessage());
        }
    }

    public ResponseCube queryCube(RequestCube requestCube) {
        if (logger.isDebugEnabled()) {
            logger.debug("Execute queryCube");
        }
        try {
            Convert convert = new Convert();
            CoordinateTo cor1 = convert.toCoordinateTo(requestCube.getOperation()[1], requestCube.getOperation()[2], requestCube.getOperation()[3]);
            CoordinateTo cor2 = convert.toCoordinateTo(requestCube.getOperation()[4], requestCube.getOperation()[5], requestCube.getOperation()[6]);
            long a = 0;
            for (int x = cor1.getX(); x <= cor2.getX(); x++) {
                for (int y = cor1.getY(); y <= cor2.getY(); y++) {
                    for (int z = cor1.getZ(); z <= cor2.getZ(); z++) {
                        a += requestCube.getCube().getCubeValue(new CoordinateTo(x, y, z));
                    }
                }
            }
            return new ResponseCube(requestCube.getCube(), "Resultado del Query " + a);
        } catch (InvalidParameterException e) {
            logger.error(e.getMessage(), e);
            return new ResponseCube(requestCube.getCube(), e.getMessage());
        }
    }

}
