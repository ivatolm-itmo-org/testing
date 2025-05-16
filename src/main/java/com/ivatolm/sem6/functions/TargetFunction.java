package com.ivatolm.sem6.functions;

import com.ivatolm.sem6.Calculator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TargetFunction implements Calculator {

    private SinCalculator sinCalc;
    private CosCalculator cosCalc;
    private TanCalculator tanCalc;
    private CotCalculator cotCalc;
    private SecCalculator secCalc;
    private CscCalculator cscCalc;

    @Override
    public double calc(double x, double epsilon) {
        try {
            double sinX = sinCalc.calc(x, epsilon);
            double cosX = cosCalc.calc(x, epsilon);
            double tanX = tanCalc.calc(x, epsilon);
            double cotX = cotCalc.calc(x, epsilon);
            double secX = secCalc.calc(x, epsilon);
            double cscX = cscCalc.calc(x, epsilon);

            double A1 = (((cotX - sinX) * cosX) - sinX*sinX) * (tanX - cotX);
            double B1 = tanX * sinX;
            double Q1 = A1 / B1;

            double A2 = ((secX + cscX) / cotX) * (cscX + cotX) * cscX * cosX;
            double B2 = (((cotX + cosX) * cosX*cosX) - cscX);
            double C2 = A2*A2 + B2*B2*B2;
            double Q2 = C2 / tanX;

            double A3 = (cosX - sinX) + (cscX + cscX + cotX*cotX);
            double B3 = (Q2 + A3) * cosX;
            double Q3 = B3*B3 * (tanX + sinX);

            double A4 = Q3 / Q1;
            double B4 = sinX / cotX;
            double C4 = B4*B4;
            double D4 = C4*C4;
            double E4 = D4*D4;
            double Q4 = A4 + E4;

            return Q4;
        } catch (ArithmeticException e) {
            System.err.println("Arithmetic error: " + e.getMessage());
            return Double.NaN;
        }
    }

}
