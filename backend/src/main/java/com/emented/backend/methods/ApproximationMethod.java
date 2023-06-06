package com.emented.backend.methods;

import java.util.List;

import com.emented.backend.dto.MethodResult;
import com.emented.backend.dto.PointDto;

public interface ApproximationMethod {

    MethodResult solve(List<PointDto> pointDtos);
}
