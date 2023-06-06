package com.emented.backend.dto;

import java.util.Comparator;
import java.util.List;

import com.emented.backend.methods.ApproximationMethodEnum;

public record MethodResult(ApproximationMethodEnum method,
                            double standardDeviation,
                            List<Double> approximationFunction,
                            List<Double> epsilonList,
                            List<Double> phiList,
                            Double pirsonCoefficient) implements Comparable<MethodResult>{

    @Override
    public int compareTo(MethodResult o) {
        return Comparator
                .comparingDouble(MethodResult::standardDeviation)
                .thenComparingInt(r -> r.method().getPriority())
                .compare(this, o);
    }
}
