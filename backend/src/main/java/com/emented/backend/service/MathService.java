package com.emented.backend.service;

import com.emented.backend.dto.AnswerDto;
import com.emented.backend.dto.MethodAnswerDto;
import com.emented.backend.dto.MethodResult;
import com.emented.backend.dto.PointDto;
import com.emented.backend.methods.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MathService {

    private final List<ApproximationMethod> approximationMethodList;

    @Autowired
    public MathService(List<ApproximationMethod> approximationMethodList) {
        this.approximationMethodList = approximationMethodList;
    }

    public AnswerDto solve(List<PointDto> pointDtoList) {

        List<MethodResult> methodResultList = new ArrayList<>(approximationMethodList.size());

        for (var method : approximationMethodList) {
            MethodResult currentMethodResult = method.solve(pointDtoList);
            methodResultList.add(currentMethodResult);
        }

        methodResultList.sort(null);

        var best = methodResultList.remove(0);

        return AnswerDto.builder()
                .method(best.method().name().toLowerCase())
                .approximationFunction(best.approximationFunction())
                .standardDeviation(best.standardDeviation())
                .epsilonList(best.epsilonList())
                .phiList(best.phiList())
                .pirsonCoefficient(best.pirsonCoefficient())
                .pointDtoList(pointDtoList)
                .notBestApproximations(methodResultList.stream().map(this::convert).toList())
                .build();
    }

    private MethodAnswerDto convert(MethodResult result) {
        return new MethodAnswerDto(
                result.method().name().toLowerCase(),
                result.standardDeviation(),
                result.approximationFunction(),
                result.epsilonList(),
                result.phiList(),
                result.pirsonCoefficient()
        );
    }
}
