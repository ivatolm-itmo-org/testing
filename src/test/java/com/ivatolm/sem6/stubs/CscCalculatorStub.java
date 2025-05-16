package com.ivatolm.sem6.stubs;

import java.util.Map;

import com.ivatolm.sem6.functions.CscCalculator;
import com.ivatolm.sem6.functions.SinCalculator;
import com.ivatolm.sem6.functions.Utils;

public class CscCalculatorStub extends CscCalculator {
    private static final Map<Double, Double> STUB_VALUES = Map.of(
        Math.PI / 2, 1.0,
        Math.PI / 6, 2.0,
        3 * Math.PI / 2, -1.0,
        5 * Math.PI / 6, 2.0,
        -Math.PI / 2, -1.0
    );

    public CscCalculatorStub(SinCalculator sinCalculator) {
        super(sinCalculator);
    }

    @Override
    public double calc(double x, double epsilon) {
        x = Utils.normalizeAngle(x);
        if (!STUB_VALUES.containsKey(x)) {
            System.out.println("WARNING: No stub value for x=" + x + " in csc calc");
            throw new RuntimeException("No stub available");
        }
        return STUB_VALUES.get(x);
    }
}
