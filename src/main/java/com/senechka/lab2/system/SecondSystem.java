package com.senechka.lab2.system;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class SecondSystem implements SystemTask {
    public static String system = "sin(x) + y - 1 = 0\n\t\t-2x^3 - 4y + 5 = 0";

    private List<List<BiFunction<Double, Double, Double>>> je;

    public SecondSystem() {
        initSystem();
    }

    private void initSystem() {
        je = new ArrayList<>();

        List<BiFunction<Double, Double, Double>> firstLine = new ArrayList<>(), secondLine = new ArrayList<>();

        firstLine.add((x, y) -> Math.cos(x));
        firstLine.add((x, y) -> 1d);
        firstLine.add((x, y) -> -Math.sin(x) - y + 1);

        secondLine.add((x, y) -> -6 * x * 2);
        secondLine.add((x, y) -> -4d);
        secondLine.add((x, y) -> 2 * x * x * x + 4 * y - 5);

        je.add(firstLine);
        je.add(secondLine);
    }

    @Override
    public double firstEquation(double x, double y) {
        return 1 - Math.sin(x);
    }

    @Override
    public double secondEquation(double x, double y) {
        return (-2 * x * x * x + 5) / 4;
    }

    @Override
    public List<List<BiFunction<Double, Double, Double>>> getJe() {
        return je;
    }


}
