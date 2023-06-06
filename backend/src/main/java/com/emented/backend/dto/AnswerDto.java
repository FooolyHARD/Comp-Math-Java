package com.emented.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AnswerDto {
    private String method;
    private List<Double> approximationFunction;
    private List<Double> phiList;
    private List<Double> epsilonList;
    private List<PointDto> pointDtoList;
    private double standardDeviation;
    private double pirsonCoefficient;

    private List<MethodAnswerDto> notBestApproximations;

}
