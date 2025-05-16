package com.ivatolm.sem6.functions;

import com.ivatolm.sem6.Calculator;

public class SecCalculator implements Calculator {
    private final CosCalculator cosCalculator;

    public SecCalculator(CosCalculator cosCalculator) {
        this.cosCalculator = cosCalculator;
    }

    @Override
    public double calc(double x, double epsilon) {
        x = Utils.normalizeAngle(x);
        double cosValue = cosCalculator.calc(x, epsilon);
        if (Math.abs(cosValue) < epsilon) {
            throw new ArithmeticException("Division by zero: cos(x) is too close to 0 when x = " + x);
        }
        return 1 / cosValue;
    }
}
