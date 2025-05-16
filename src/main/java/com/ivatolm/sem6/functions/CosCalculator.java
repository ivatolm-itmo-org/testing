package com.ivatolm.sem6.functions;

import com.ivatolm.sem6.Calculator;

public class CosCalculator implements Calculator {
    private final SinCalculator sinCalculator;

    public CosCalculator(SinCalculator sinCalculator) {
        this.sinCalculator = sinCalculator;
    }

    @Override
    public double calc(double x, double epsilon) {
        x = Utils.normalizeAngle(x);
        double convertation = x + Math.PI / 2;
        return sinCalculator.calc(convertation, epsilon);
    }
}
