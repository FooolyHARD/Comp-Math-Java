package com.emented.backend.methods;

import com.emented.backend.dto.MethodResult;
import com.emented.backend.dto.PointDto;
import com.emented.backend.math.ApproximationCounter;
import com.emented.backend.math.GaussSystemSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class CubicMethod implements ApproximationMethod {

    private final GaussSystemSolver gauss;
    private final ApproximationCounter approximationCounter;

    @Autowired
    public CubicMethod(GaussSystemSolver gauss, ApproximationCounter approximationCounter) {
        this.gauss = gauss;
        this.approximationCounter = approximationCounter;
    }

    public MethodResult solve(List<PointDto> pointDtos) {
        int n = pointDtos.size();

        double SX = 0;
        double SY = 0;

        double S2X = 0;
        double S3X = 0;
        double S4X = 0;
        double S5X = 0;
        double S6X = 0;

        double SXY = 0;
        double SXXY = 0;
        double SXXXY = 0;

        for (PointDto p : pointDtos) {
            double x = p.getX();
            double y = p.getY();
            SX += x;
            SY += y;

            S2X += x * x;
            SXY += x * y;
            S3X += x * x * x;
            S4X += x * x * x * x;
            S5X += x * x * x * x * x;
            S6X += x * x * x * x * x * x;

            SXXY += x * x * y;
            SXXXY += x * x * x * y;
        }

        double[][] matrix = new double[4][5];
        matrix[0] = new double[]{n, SX, S2X, S3X, SY};
        matrix[1] = new double[]{SX, S2X, S3X, S4X, SXY};
        matrix[2] = new double[]{S2X, S3X, S4X, S5X, SXXY};
        matrix[3] = new double[]{S3X, S4X, S5X, S6X, SXXXY};

        double[] answer = gauss.solve(matrix);

        double x0 = answer[0];
        double x1 = answer[1];
        double x2 = answer[2];
        double x3 = answer[3];

        List<Double> functionCoefficients = new ArrayList<>();
        functionCoefficients.add(x0);
        functionCoefficients.add(x1);
        functionCoefficients.add(x2);
        functionCoefficients.add(x3);

        Function<Double, Double> function = x -> (x0 + x1 * x + x2 * x * x + x3 * x * x * x);

        double standardDeviation = approximationCounter.standardDeviation(pointDtos, function);

        List<Double> phis = approximationCounter.phis(pointDtos, function);

        List<Double> epsilons = approximationCounter.epsilons(pointDtos, function);

        return new MethodResult(
                ApproximationMethodEnum.CUBIC,
                standardDeviation,
                functionCoefficients,
                epsilons,
                phis,
                Double.MIN_VALUE
        );
    }
}
