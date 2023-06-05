package com.senechka.lab2.system;

import java.util.List;
import java.util.function.BiFunction;

public interface SystemTask {
    double firstEquation(double x, double y);
    double secondEquation(double x, double y);

    List<List<BiFunction<Double, Double, Double>>> getJe();

}
