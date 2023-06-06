package com.emented.backend.methods;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApproximationMethodEnum {

    LINEAR(0),
    SQUARE(1),
    CUBIC(2),
    EXPONENTIAL(3),
    LOGARITHMIC(4),
    POWER(5);


    private final int priority;
}
