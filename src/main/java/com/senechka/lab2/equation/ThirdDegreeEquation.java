package com.senechka.lab2.equation;

public class ThirdDegreeEquation implements Equation {
    public static String equation = "x^3 + 2,28*x^2 − 1,934*x − 3,907";

    @Override
    public double f(double x) {
        return x * x * x + 2.28 * x * x - 1.934 * x - 3.907;
    }

    @Override
    public double fDerivative(double x) {
        return 3 * x * x + 2 * 2.28 * x - 1.934;
    }

    @Override
    public String toString() {
        return equation;
    }
}
