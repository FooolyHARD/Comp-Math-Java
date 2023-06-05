package com.senechka.lab2.dto;

import com.senechka.lab2.equation.Equation;

public class AnswerEquation {
    private double x;
    private int i;
    private Equation equation;
    private InputData interval;

    public AnswerEquation(double x, int i, Equation equation, InputData interval) {
        this.x = x;
        this.i = i;
        this.equation = equation;
        this.interval = interval;
    }

    public double getX() {
        return x;
    }

    public Equation getEquation() {
        return equation;
    }

    public InputData getInterval() {
        return interval;
    }

    @Override
    public String toString() {
        return "Ответ: " +
                "x=" + x +
                ", был получен за " + i +
                " итераций";
    }
}
