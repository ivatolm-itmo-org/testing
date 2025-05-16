package com.ivatolm.sem6.stubs;

import java.util.Map;

import com.ivatolm.sem6.Calculator;

public class CscCalculatorStub implements Calculator {
    private static final Map<Double, Double> STUB_VALUES = Map.of(
        Math.PI / 2, 1.0,
        Math.PI / 6, 2.0,
        3 * Math.PI / 2, -1.0,
        5 * Math.PI / 6, 2.0,
        -Math.PI / 2, -1.0
    );

    @Override
    public double calc(double x, double epsilon) {
        if (!STUB_VALUES.containsKey(x)) {
            System.out.println("WARNING: No stub value for x=" + x + " in csc calc");
            throw new RuntimeException("No stub available");
        }
        return STUB_VALUES.get(x);
    }
}
