package com.ivatolm.sem6.stubs;

import java.util.Map;

import com.ivatolm.sem6.functions.SinCalculator;
import com.ivatolm.sem6.functions.Utils;

public class SinCalculatorStub extends SinCalculator {
    private static final Map<Double, Double> STUB_VALUES = Map.of(
        0.0, 0.0,
        Math.PI / 6, 0.5,
        Math.PI / 2, 1.0,
        Math.PI, 0.0
    );

    @Override
    public double calc(double x, double epsilon) {
        x = Utils.normalizeAngle(x);
        if (!STUB_VALUES.containsKey(x)) {
            System.out.println("WARNING: There is no stub value for x=" + x + " in sin calc");
            throw new RuntimeException("No stub available");
        }
        return STUB_VALUES.get(x);
    }
}
