package com.ivatolm.sem6.functions;

import com.ivatolm.sem6.Calculator;

public class TanCalculator implements Calculator {
    private final SinCalculator sinCalculator;
    private final CosCalculator cosCalculator;

    public TanCalculator(SinCalculator sinCalculator, CosCalculator cosCalculator) {
        this.sinCalculator = sinCalculator;
        this.cosCalculator = cosCalculator;
    }

    @Override
    public double calc(double x, double epsilon) {
        x = Utils.normalizeAngle(x);

        double sinValue = sinCalculator.calc(x, epsilon);
        double cosValue = cosCalculator.calc(x, epsilon);

        if (Math.abs(cosValue) < epsilon) {
            throw new ArithmeticException("Division by zero: cos(x) is too close to 0 when x = " + x);
        }

        return sinValue / cosValue;
    }
}
