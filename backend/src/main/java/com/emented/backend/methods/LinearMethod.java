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
public class LinearMethod implements ApproximationMethod {

    private final GaussSystemSolver gauss;
    private final ApproximationCounter approximationCounter;

    @Autowired
    public LinearMethod(GaussSystemSolver gauss, ApproximationCounter approximationCounter) {
        this.gauss = gauss;
        this.approximationCounter = approximationCounter;
    }

    public MethodResult solve(List<PointDto> pointDtos) {
        return solve(pointDtos, pointDtos,false, ApproximationMethodEnum.LINEAR);
    }

    public MethodResult solve(List<PointDto> pointDtos, List<PointDto> pointDtoBefore, boolean aToExp, ApproximationMethodEnum method) {
        int n = pointDtos.size();

        double SX = 0;
        double SY = 0;
        double SXX = 0;
        double SXY = 0;

        for (PointDto p : pointDtos) {
            double x = p.getX();
            double y = p.getY();
            SX += x;
            SY += y;
            SXX += x * x;
            SXY += x * y;
        }
        double[][] matrix = new double[2][3];
        matrix[0] = new double[]{n, SX, SY};
        matrix[1] = new double[]{SX, SXX, SXY};

        double[] answer = gauss.solve(matrix);
        double a = answer[0];
        double b = answer[1];

        List<Double> functionCoefficients = new ArrayList<>();
        functionCoefficients.add(aToExp ? Math.exp(a) : a);
        functionCoefficients.add(b);

        Function<Double, Double> function = (x -> a + b * x);
        Function<Double, Double> calculatedFunction = specialFunction(functionCoefficients, method, function);

        double standardDeviation = approximationCounter.standardDeviation(pointDtoBefore, calculatedFunction);

        List<Double> phis = approximationCounter.phis(pointDtoBefore, calculatedFunction);

        List<Double> epsilons = approximationCounter.epsilons(pointDtoBefore, calculatedFunction);

        double pirsonCoefficient = approximationCounter.pirsonCoefficient(pointDtos);

        return new MethodResult(
                method,
                standardDeviation,
                functionCoefficients,
                epsilons,
                phis,
                pirsonCoefficient
        );
    }

    private Function<Double, Double> specialFunction(List<Double> coefficients,
                                                     ApproximationMethodEnum method,
                                                     Function<Double, Double> defaultFunction) {
        return switch (method) {
            case LOGARITHMIC -> x -> coefficients.get(1) * Math.log(x) + coefficients.get(0);
            case POWER -> x -> coefficients.get(0) * Math.pow(x, coefficients.get(1));
            case EXPONENTIAL -> x -> coefficients.get(0) * Math.exp(coefficients.get(1) * x);
            default -> defaultFunction;
        };
    }

}
