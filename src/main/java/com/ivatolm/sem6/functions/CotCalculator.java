package com.ivatolm.sem6.functions;

import com.ivatolm.sem6.Calculator;

public class CotCalculator implements Calculator {
    private final SinCalculator sinCalculator;
    private final CosCalculator cosCalculator;

    public CotCalculator(SinCalculator sinCalculator, CosCalculator cosCalculator) {
        this.sinCalculator = sinCalculator;
        this.cosCalculator = cosCalculator;
    }

    @Override
    public double calc(double x, double epsilon) {
        double sinValue = sinCalculator.calc(x, epsilon);
        double cosValue = cosCalculator.calc(x, epsilon);

        if (Math.abs(sinValue) < epsilon) {
            throw new ArithmeticException("Division by zero: sin(x) is too close to 0 when x = " + x);
        }

        return cosValue / sinValue;
    }
}
