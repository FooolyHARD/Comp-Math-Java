package com.emented.backend.methods;

import com.emented.backend.dto.MethodResult;
import com.emented.backend.dto.PointDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class LogarithmicMethod implements ApproximationMethod {

    private final LinearMethod linearMethod;

    @Autowired
    public LogarithmicMethod(LinearMethod linearMethod) {
        this.linearMethod = linearMethod;
    }

    public MethodResult solve(List<PointDto> pointDtos) {
        List<PointDto> newPointDtos = new ArrayList<>(pointDtos.size());
        for (PointDto p : pointDtos) {
            var newP = new PointDto();
            double x = p.getX();
            if (x <= 0) {
                return new MethodResult(ApproximationMethodEnum.LOGARITHMIC,
                        Double.MAX_VALUE,
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        Double.MIN_VALUE);
            }

            newP.setX(Math.log(x));
            newP.setY(p.getY());
            newPointDtos.add(newP);
        }

        return linearMethod.solve(newPointDtos, pointDtos, false, ApproximationMethodEnum.LOGARITHMIC);
    }
}
