package com.ivatolm.sem6.stubs;

import java.util.Map;

import com.ivatolm.sem6.Calculator;

public class SecCalculatorStub implements Calculator {
    private static final Map<Double, Double> STUB_VALUES = Map.of(
        0.0, 1.0,
        Math.PI, -1.0,
        Math.PI / 3, 2.0,
        Math.PI / 4, Math.sqrt(2),
        2 * Math.PI / 3, -2.0,
        Math.PI / 6, 2/ Math.sqrt(3)
    );

    @Override
    public double calc(double x, double epsilon) {
        if (!STUB_VALUES.containsKey(x)) {
            System.out.println("WARNING: No stub value for x=" + x + " in sec calc");
        }
        return STUB_VALUES.getOrDefault(x, 0.0);
    }
}
