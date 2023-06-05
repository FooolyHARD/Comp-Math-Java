package com.senechka.lab2.dto;

public class InputData {
    private double a;
    private double b;
    private double epsilon;

    public InputData(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public InputData(double a, double b, double epsilon) {
        this.a = a;
        this.b = b;
        this.epsilon = epsilon;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    @Override
    public String toString() {
        return "интервал изоляции: [" +
                a +
                ", " + b +
                ']';
    }
}
