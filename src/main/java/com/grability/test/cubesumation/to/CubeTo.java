/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grability.test.cubesumation.to;

/**
 *
 * @author Frank
 */
public class CubeTo {

    private long cube[][][];

    public CubeTo(CoordinateTo coord) {
        this.cube = new long[coord.getX()][coord.getY()][coord.getZ()];
    }

    public CubeTo() {
    }

    public long getCubeValue(CoordinateTo coord) {
        coord.setX(coord.getX() - 1);
        coord.setY(coord.getY() - 1);
        coord.setZ(coord.getZ() - 1);
        return this.cube[coord.getX()][coord.getY()][coord.getZ()];
    }

    public void setCubeValue(CoordinateTo coord, long value) {
        coord.setX(coord.getX() - 1);
        coord.setY(coord.getY() - 1);
        coord.setZ(coord.getZ() - 1);
        this.cube[coord.getX()][coord.getY()][coord.getZ()] = value;
    }

    public long[][][] getCube() {
        return cube;
    }

    public void setCube(long[][][] cube) {
        this.cube = cube;
    }
}
