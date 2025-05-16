package com.ivatolm.sem6.stubs;

import java.util.Map;

import com.ivatolm.sem6.Calculator;

public class SinCalculatorStub implements Calculator {
    private static final Map<Double, Double> STUB_VALUES = Map.of(
        0.0, 0.0,
        Math.PI / 6, 0.5,
        Math.PI / 2, 1.0,
        Math.PI, 0.0
    );

    @Override
    public double calc(double x, double epsilon) {
        if (!STUB_VALUES.containsKey(x)) {
            System.out.println("WARNING: There is no stub value for x=" + x + " in sin calc");
            throw new RuntimeException("No stub available");
        }
        return STUB_VALUES.get(x);
    }
}
