/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grability.test.cubesumation.dao;

import com.grability.test.cubesumation.exception.InvalidParameterException;
import com.grability.test.cubesumation.to.CoordinateTo;
import com.grability.test.cubesumation.to.CubeTo;
import com.grability.test.cubesumation.to.RequestCubeTo;
import com.grability.test.cubesumation.to.ResponseCubeTo;
import com.grability.test.cubesumation.bf.ConvertBf;
import com.grability.test.cubesumation.util.Validate;
import org.apache.log4j.Logger;

/**
 *
 * @author Frank
 */
public class CubeDao {
    
    private static final Logger logger = Logger.getLogger(CubeDao.class);

    public ResponseCubeTo createCube(RequestCubeTo requestCube) {
        if (logger.isDebugEnabled()) {
            logger.debug("Execute createCube");
        }
        try {
            return new ResponseCubeTo(new CubeTo(new ConvertBf().toCoordinateTo(requestCube.getOperation()[0], requestCube.getOperation()[0], requestCube.getOperation()[0])), "Cubo Creado restan " + new Validate().isNumber(requestCube.getOperation()[1]) + " operaciones");
        } catch (InvalidParameterException e) {
            logger.error(e.getMessage(), e);
            return new ResponseCubeTo(requestCube.getCube(), e.getMessage());
        }
    }

    public ResponseCubeTo UpdateCube(RequestCubeTo requestCube) {
        if (logger.isDebugEnabled()) {
            logger.debug("Execute UpdateCube");
        }
        try {
            requestCube.getCube().setCubeValue(new ConvertBf().toCoordinateTo(requestCube.getOperation()[1], requestCube.getOperation()[2], requestCube.getOperation()[3]), new Validate().isNumber(requestCube.getOperation()[4]));
            return new ResponseCubeTo(requestCube.getCube(), "Valor de la coordenada modificada correctamente");
        } catch (InvalidParameterException e) {
            logger.error(e.getMessage(), e);
            return new ResponseCubeTo(requestCube.getCube(), e.getMessage());
        }
    }

    public ResponseCubeTo queryCube(RequestCubeTo requestCube) {
        if (logger.isDebugEnabled()) {
            logger.debug("Execute queryCube");
        }
        try {
            ConvertBf convert = new ConvertBf();
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
            return new ResponseCubeTo(requestCube.getCube(), "Resultado del Query " + a);
        } catch (InvalidParameterException e) {
            logger.error(e.getMessage(), e);
            return new ResponseCubeTo(requestCube.getCube(), e.getMessage());
        }
    }

}
