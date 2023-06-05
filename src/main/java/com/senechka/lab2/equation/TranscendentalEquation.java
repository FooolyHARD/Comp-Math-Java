package com.senechka.lab2.equation;


// pi/2 + 2*k*pi/3     pi/2 + k*pi
public class TranscendentalEquation implements Equation {
    public static String equation = "sin(2x) + cos(x) = 0";

    @Override
    public double f(double x) {
        return Math.sin(2 * x) + Math.cos(x);
    }

    @Override
    public double fDerivative(double x) {
        return 2 * Math.cos(2 * x) - Math.sin(x);
    }

    @Override
    public String toString() {
        return equation;
    }
}
