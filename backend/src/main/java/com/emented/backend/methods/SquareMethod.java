package com.emented.backend.methods;

import com.emented.backend.dto.MethodResult;
import com.emented.backend.dto.PointDto;
import com.emented.backend.math.ApproximationCounter;
import com.emented.backend.math.GaussSystemSolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class SquareMethod implements ApproximationMethod {


    private final GaussSystemSolver gauss;
    private final ApproximationCounter approximationCounter;

    public SquareMethod(GaussSystemSolver gauss, ApproximationCounter approximationCounter) {
        this.gauss = gauss;
        this.approximationCounter = approximationCounter;
    }

    public MethodResult solve(List<PointDto> pointDtos) {
        int n = pointDtos.size();

        double SX = 0;
        double SY = 0;

        double SXX = 0;
        double SXXX = 0;
        double SXXXX = 0;

        double SXY = 0;
        double SXXY = 0;

        for (PointDto p : pointDtos) {
            double x = p.getX();
            double y = p.getY();
            SX += x;
            SY += y;
            SXX += x * x;
            SXY += x * y;
            SXXX += x * x * x;
            SXXXX += x * x * x * x;
            SXXY += x * x * y;
        }

        double[][] matrix = new double[3][4];
        matrix[0] = new double[]{n, SX, SXX, SY};
        matrix[1] = new double[]{SX, SXX, SXXX, SXY};
        matrix[2] = new double[]{SXX, SXXX, SXXXX, SXXY};
        double[] answer = gauss.solve(matrix);


        double x0 = answer[0];
        double x1 = answer[1];
        double x2 = answer[2];

        List<Double> functionCoefficients = new ArrayList<>();
        functionCoefficients.add(x0);
        functionCoefficients.add(x1);
        functionCoefficients.add(x2);

        Function<Double, Double> function = x -> (x0 + x1 * x + x2 * x * x);

        double standardDeviation = approximationCounter.standardDeviation(pointDtos, function);

        List<Double> phis = approximationCounter.phis(pointDtos, function);

        List<Double> epsilons = approximationCounter.epsilons(pointDtos, function);

        return new MethodResult(
                ApproximationMethodEnum.SQUARE,
                standardDeviation,
                functionCoefficients,
                epsilons,
                phis,
                Double.MIN_VALUE
        );
    }
}
