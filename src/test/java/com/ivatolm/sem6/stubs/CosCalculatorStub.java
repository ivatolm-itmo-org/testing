package com.ivatolm.sem6.stubs;

import java.util.Map;

import com.ivatolm.sem6.functions.SinCalculator;
import com.ivatolm.sem6.functions.Utils;
import com.ivatolm.sem6.functions.CosCalculator;

public class CosCalculatorStub extends CosCalculator {
    private static final Map<Double, Double> STUB_VALUES = Map.of(
        0.0, 1.0,
        Math.PI / 3, 0.5,
        Math.PI / 2, 0.0,
        Math.PI / 6, Math.sqrt(3)/2,
        Math.PI, -1.0,
        2 * Math.PI / 3, -0.5,
        3 * Math.PI / 2, 0.0,
        2 * Math.PI, 1.0
    );

    public CosCalculatorStub(SinCalculator sinCalculator) {
        super(sinCalculator);
    }

    @Override
    public double calc(double x, double epsilon) {
        x = Utils.normalizeAngle(x);
        if (!STUB_VALUES.containsKey(x)) {
            System.out.println("WARNING: There is no stub value for x=" + x + " in cos calc");
            throw new RuntimeException("No stub available");
        }
        return STUB_VALUES.get(x);
    }
}
