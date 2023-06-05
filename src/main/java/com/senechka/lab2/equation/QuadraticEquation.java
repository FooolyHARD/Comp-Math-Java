package com.senechka.lab2.equation;


// 1,35435     6,64575
public class QuadraticEquation implements Equation {
    public static String equation = "x^2 - 8*x + 9";


    @Override
    public double f(double x) {
        return x * x - 8 * x + 9;
    }

    @Override
    public double fDerivative(double x) {
        return 2 * x - 8;
    }

    @Override
    public String toString() {
        return equation;
    }
}
