package com.senechka.lab2.math;

import com.senechka.lab2.dto.AnswerEquation;
import com.senechka.lab2.dto.InputData;
import com.senechka.lab2.equation.Equation;

public interface EquationSolutionMethod {

    AnswerEquation solveEquation(Equation equation, InputData interval);

}
