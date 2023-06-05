package com.senechka.lab2.dto;

public class MatrixData {
    private Integer n;
    private double e;

    private double[][] matrix;

    public MatrixData(Integer n,  double[][] matrix) {
        this.n = n;
        this.e = 0.001;
        this.matrix = matrix;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }
}
