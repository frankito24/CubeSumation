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
public class ResponseCubeTo {

    private CubeTo cube;
    private String response;

    public ResponseCubeTo(CubeTo cube, String response) {
        this.cube = cube;
        this.response = response;
    }

    public ResponseCubeTo() {
    }

    public CubeTo getCube() {
        return cube;
    }

    public void setCube(CubeTo cube) {
        this.cube = cube;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
