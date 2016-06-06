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

    private CoordinateTo coordinate;
    private long cube[][][];
    private String result;

    public CubeTo(CoordinateTo coord) {
        this.coordinate = coord;
        this.cube = new long[coord.getX()][coord.getY()][coord.getZ()];
    }
    
    public CubeTo() {
    }

    public long getCubeValue(CoordinateTo coord) {
        coord.setX(coord.getX()-1);
        coord.setY(coord.getY()-1);
        coord.setZ(coord.getZ()-1);
        return this.cube[coord.getX()][coord.getY()][coord.getZ()];
    }

    public void setCubeValue(CoordinateTo coord, long value) {
        coord.setX(coord.getX()-1);
        coord.setY(coord.getY()-1);
        coord.setZ(coord.getZ()-1);
        this.cube[coord.getX()][coord.getY()][coord.getZ()] = value;
    }

//    private int[] cube;
//
//    public CubeTo(CoordinateTo coord) {
//        this.coordinate = coord;
//        cube = new int[this.coordinate.getX() * this.coordinate.getY() * this.coordinate.getZ()];
//    }
//
//    public int getCubeValue(int x, int y, int z) {
//        x = x -1;
//        y = y -1;
//        z = z -1;
//        return cube[x * this.coordinate.getY() * this.coordinate.getZ() + y * this.coordinate.getZ() + z];
//    }
//
//    public void setCubeValue(int x, int y, int z, int value) {
//        x = x -1;
//        y = y -1;
//        z = z -1;
//        cube[x * this.coordinate.getY() * this.coordinate.getZ() + y * this.coordinate.getZ() + z] = value;
//    }
}
