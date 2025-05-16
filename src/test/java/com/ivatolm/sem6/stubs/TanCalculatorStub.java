package com.ivatolm.sem6.stubs;

import java.util.Map;

import com.ivatolm.sem6.Calculator;

public class TanCalculatorStub implements Calculator {
    private static final Map<Double, Double> STUB_VALUES = Map.of(
        0.0, 0.0,
        Math.PI / 6, 1 / Math.sqrt(3),
        Math.PI / 4, 1.0,
        Math.PI / 3, Math.sqrt(3),
        -Math.PI / 6, -1 / Math.sqrt(3),
        -Math.PI / 4, -1.0,
        -Math.PI / 3, -Math.sqrt(3)
    );

    @Override
    public double calc(double x, double epsilon) {
        if (!STUB_VALUES.containsKey(x)) {
            System.out.println("WARNING: No stub value for x=" + x + " in tan calc");
            throw new RuntimeException("No stub available");
        }
        return STUB_VALUES.get(x);
    }
}
