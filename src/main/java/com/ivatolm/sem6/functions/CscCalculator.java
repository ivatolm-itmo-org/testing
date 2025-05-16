package com.ivatolm.sem6.functions;

import com.ivatolm.sem6.Calculator;

public class CscCalculator implements Calculator {
    private final SinCalculator sinCalculator;

    public CscCalculator(SinCalculator sinCalculator) {
        this.sinCalculator = sinCalculator;
    }

    @Override
    public double calc(double x, double epsilon) {
        x = Utils.normalizeAngle(x);
        double sinValue = sinCalculator.calc(x, epsilon);
        if (Math.abs(sinValue) < epsilon) {
            throw new ArithmeticException("Division by zero: sin(x) is too close to 0 when x = " + x);
        }
        return 1 / sinValue;
    }
}
