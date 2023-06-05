package com.senechka.lab2.system;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class FirstSystem implements SystemTask {
    public static String system = "x^2 + y^2 = 4\n\t\ty = 3x^2";

    private List<List<BiFunction<Double, Double, Double>>> je;

    public FirstSystem() {
        initSystem();
    }

    private void initSystem() {
        je = new ArrayList<>();

        List<BiFunction<Double, Double, Double>> firstLine = new ArrayList<>(), secondLine = new ArrayList<>();

        firstLine.add((x, y) -> 2 * x);
        firstLine.add((x, y) -> 2 * y);
        firstLine.add((x, y) -> 4 - x * x - y * y);

        secondLine.add((x, y) -> -6 * x);
        secondLine.add((x, y) -> 1d);
        secondLine.add((x, y) -> 3 * x * x - y);

        je.add(firstLine);
        je.add(secondLine);
    }

    @Override
    public double firstEquation(double x, double y) {
        return Math.sqrt(4 - x * x);
    }

    @Override
    public double secondEquation(double x, double y) {
        return 3 * x * x;
    }

    public List<List<BiFunction<Double, Double, Double>>> getJe() {
        return je;
    }

}
