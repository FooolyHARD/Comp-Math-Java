package com.emented.backend.methods;

import com.emented.backend.dto.MethodResult;
import com.emented.backend.dto.PointDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PowerMethod implements ApproximationMethod {

    private final LinearMethod linearMethod;

    @Autowired
    public PowerMethod(LinearMethod linearMethod) {
        this.linearMethod = linearMethod;
    }

    public MethodResult solve(List<PointDto> pointDtos) {
        List<PointDto> newPointDtos = new ArrayList<>(pointDtos.size());
        for (PointDto p : pointDtos) {
            var newP = new PointDto();
            double x = p.getX();
            double y = p.getY();

            if (y <= 0 || x <= 0) {
                return new MethodResult(ApproximationMethodEnum.POWER,
                        Double.MAX_VALUE,
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        Double.MIN_VALUE);
            }

            newP.setX(Math.log(x));
            newP.setY(Math.log(y));

            newPointDtos.add(newP);
        }

        return linearMethod.solve(newPointDtos, pointDtos, true, ApproximationMethodEnum.POWER);
    }
}
