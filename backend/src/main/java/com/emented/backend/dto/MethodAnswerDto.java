package com.emented.backend.dto;

import java.util.List;

public record MethodAnswerDto(String method,
                              double standardDeviation,
                              List<Double> approximationFunction,
                              List<Double> epsilonList,
                              List<Double> phiList,
                              Double pirsonCoefficient) {
}
