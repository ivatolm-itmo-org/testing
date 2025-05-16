package com.ivatolm.sem6.stubs;

import java.util.Map;

import com.ivatolm.sem6.functions.CosCalculator;
import com.ivatolm.sem6.functions.SecCalculator;
import com.ivatolm.sem6.functions.Utils;

public class SecCalculatorStub extends SecCalculator {
    private static final Map<Double, Double> STUB_VALUES = Map.of(
        0.0, 1.0,
        Math.PI, -1.0,
        Math.PI / 3, 2.0,
        Math.PI / 4, Math.sqrt(2),
        2 * Math.PI / 3, -2.0,
        Math.PI / 6, 2/ Math.sqrt(3)
    );

    public SecCalculatorStub(CosCalculator cosCalculator) {
        super(cosCalculator);
    }

    @Override
    public double calc(double x, double epsilon) {
        x = Utils.normalizeAngle(x);
        if (!STUB_VALUES.containsKey(x)) {
            System.out.println("WARNING: No stub value for x=" + x + " in sec calc");
        }
        return STUB_VALUES.getOrDefault(x, 0.0);
    }
}
