package com.emented.backend.math;

import com.emented.backend.dto.PointDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


@Component
public class ApproximationCounter {
    public double standardDeviation(List<PointDto> pointDtos, Function<Double, Double> function) {
        double s = 0;

        for (PointDto p : pointDtos) {
            s += Math.pow(function.apply(p.getX()) - p.getY(), 2);
        }

        return Math.sqrt(s / pointDtos.size());
    }

    public List<Double> phis(List<PointDto> pointDtos, Function<Double, Double> function) {
        List<Double> res = new ArrayList<>();

        for (PointDto p : pointDtos) {
            res.add(function.apply(p.getX()));
        }

        return res;
    }

    public List<Double> epsilons(List<PointDto> pointDtos, Function<Double, Double> function) {
        List<Double> res = new ArrayList<>();

        for (PointDto p : pointDtos) {
            res.add(function.apply(p.getX()) - p.getY());
        }

        return res;
    }

    public double pirsonCoefficient(List<PointDto> pointDtos) {
        double sumX = 0;
        double sumY = 0;
        int n = pointDtos.size();

        for (PointDto p : pointDtos) {
            sumX += p.getX();
            sumY += p.getY();
        }

        double meanX = sumX / n;
        double meanY = sumY / n;

        double numerator = 0;
        double denominatorX = 0;
        double denominatorY = 0;

        for (PointDto p : pointDtos) {
            double deviationX = p.getX() - meanX;
            double deviationY = p.getY() - meanY;

            numerator += deviationX * deviationY;
            denominatorX += deviationX * deviationX;
            denominatorY += deviationY * deviationY;
        }

        double denominator = Math.sqrt(denominatorX) * Math.sqrt(denominatorY);

        return numerator / denominator;
    }
}
