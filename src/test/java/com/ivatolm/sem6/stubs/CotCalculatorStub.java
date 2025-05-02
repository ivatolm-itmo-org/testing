package com.ivatolm.sem6.stubs;

import java.util.Map;

import com.ivatolm.sem6.Calculator;

public class CotCalculatorStub implements Calculator {
    private static final Map<Double, Double> STUB_VALUES = Map.of(
        Math.PI / 4, 1.0,
        Math.PI / 3, 1 / Math.sqrt(3),
        Math.PI / 6, Math.sqrt(3),
        Math.PI / 2, 0.0,
        -Math.PI / 4, -1.0
    );

    @Override
    public double calc(double x, double epsilon) {
        if (!STUB_VALUES.containsKey(x)) {
            System.out.println("WARNING: No stub value for x=" + x + " in cot calc");
        }
        return STUB_VALUES.getOrDefault(x, 0.0);
    }
}
