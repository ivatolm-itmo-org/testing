package com.ivatolm.sem6.stubs;

import java.util.Map;

import com.ivatolm.sem6.functions.CosCalculator;
import com.ivatolm.sem6.functions.CotCalculator;
import com.ivatolm.sem6.functions.SinCalculator;
import com.ivatolm.sem6.functions.Utils;

public class CotCalculatorStub extends CotCalculator {
    private static final Map<Double, Double> STUB_VALUES = Map.of(
        Math.PI / 4, 1.0,
        Math.PI / 3, 1 / Math.sqrt(3),
        Math.PI / 6, Math.sqrt(3),
        Math.PI / 2, 0.0,
        -Math.PI / 4, -1.0
    );

    public CotCalculatorStub(SinCalculator sinCalculator, CosCalculator cosCalculator) {
        super(sinCalculator, cosCalculator);
    }

    @Override
    public double calc(double x, double epsilon) {
        x = Utils.normalizeAngle(x);
        if (!STUB_VALUES.containsKey(x)) {
            System.out.println("WARNING: No stub value for x=" + x + " in cot calc");
            throw new RuntimeException("No stub available");
        }
        return STUB_VALUES.get(x);
    }
}
