package com.senechka.lab2.math;

import com.senechka.lab2.dto.AnswerEquation;
import com.senechka.lab2.dto.InputData;
import com.senechka.lab2.equation.Equation;

public class SecantMethod implements EquationSolutionMethod {
    @Override
    public AnswerEquation solveEquation(Equation equation, InputData interval) {

        double x0 = interval.getA();
        double x1 = x0 + 0.03;
        int i = 0;
        double x2 = 0;
        double epsilon = interval.getEpsilon();

        do {
            i++;
            x2 = x1 - ((x1 - x0) / (equation.f(x1) - equation.f(x0)) * equation.f(x1));

            double m = Math.abs(x2 - x1);
            System.out.println(x0 + " " + x1 + " " + x2);
            if (m <= epsilon) {
                break;
            }
            x0 = x1;
            x1 = x2;

        } while (true);

        return new AnswerEquation(x2, i, equation, interval);
    }
}
