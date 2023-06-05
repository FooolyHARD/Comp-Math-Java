package com.senechka.lab2.math;

import com.senechka.lab2.dto.AnswerSystem;
import com.senechka.lab2.dto.BigInterval;
import com.senechka.lab2.system.SystemTask;

public interface SystemSolutionMethod {
    AnswerSystem proceed(BigInterval interval, SystemTask system);
}
