package com.senechka.lab2.math;

import com.senechka.lab2.dto.AnswerEquation;
import com.senechka.lab2.dto.InputData;
import com.senechka.lab2.equation.Equation;

public class SimpleIterationMethod implements EquationSolutionMethod {
    @Override
    public AnswerEquation solveEquation(Equation equation, InputData interval) {

        double a = interval.getA();
        double b = interval.getB();
        double epsilon = interval.getEpsilon();

        double aD = equation.fDerivative(a);
        double bD = equation.fDerivative(b);

        double lambda = -1 / Math.max(aD, bD);

        double x0 = b;
        double x1 = fi(x0, equation, lambda);

        int i = 0;

        do {
            i++;
            double x2 = fi(x1, equation, lambda);

            double m = Math.abs(x1 - x0);

            if (m <= epsilon) {
                break;
            }

            x0 = x1;
            x1 = x2;
        } while (true);

        return new AnswerEquation(x1, i, equation, interval);
    }

    private double fi(double x, Equation equation, double lambda) {

        return x + lambda * equation.f(x);
    }
}
