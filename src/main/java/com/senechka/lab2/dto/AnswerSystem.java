package com.senechka.lab2.dto;

import com.senechka.lab2.system.SystemTask;

public class AnswerSystem {
    private double x;
    private double y;
    private int i;
    private SystemTask system;
    private BigInterval interval;

    public AnswerSystem(double x, double y, int i, SystemTask system, BigInterval interval) {
        this.x = x;
        this.y = y;
        this.i = i;
        this.system = system;
        this.interval = interval;
    }

    public BigInterval getInterval() {
        return interval;
    }

    public SystemTask getSystem() {
        return system;
    }

    @Override
    public String toString() {
        return "Ответ: " +
                "x=" + x + ", " +
                "y=" + y +
                ", был получен за " + i +
                " итераций";
    }
}
