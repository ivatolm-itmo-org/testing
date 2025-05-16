package com.ivatolm.sem6.stubs;

import java.util.Map;

import com.ivatolm.sem6.functions.CosCalculator;
import com.ivatolm.sem6.functions.SinCalculator;
import com.ivatolm.sem6.functions.TanCalculator;
import com.ivatolm.sem6.functions.Utils;

public class TanCalculatorStub extends TanCalculator {
    private static final Map<Double, Double> STUB_VALUES = Map.of(
        0.0, 0.0,
        Math.PI / 6, 1 / Math.sqrt(3),
        Math.PI / 4, 1.0,
        Math.PI / 3, Math.sqrt(3),
        -Math.PI / 6, -1 / Math.sqrt(3),
        -Math.PI / 4, -1.0,
        -Math.PI / 3, -Math.sqrt(3)
    );

    public TanCalculatorStub(SinCalculator sinCalculator, CosCalculator cosCalculator) {
        super(sinCalculator, cosCalculator);
    }

    @Override
    public double calc(double x, double epsilon) {
        x = Utils.normalizeAngle(x);
        if (!STUB_VALUES.containsKey(x)) {
            System.out.println("WARNING: No stub value for x=" + x + " in tan calc");
            throw new RuntimeException("No stub available");
        }
        return STUB_VALUES.get(x);
    }
}
