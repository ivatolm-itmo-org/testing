package com.ivatolm.sem6;

import com.ivatolm.sem6.functions.CosCalculator;
import com.ivatolm.sem6.functions.CotCalculator;
import com.ivatolm.sem6.functions.CscCalculator;
import com.ivatolm.sem6.functions.SecCalculator;
import com.ivatolm.sem6.functions.SinCalculator;
import com.ivatolm.sem6.functions.TanCalculator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class App {
    private Calculator sinCalc;
    private Calculator tanCalc;
    private Calculator cosCalc;
    private Calculator cotCalc;
    private Calculator secCalc;
    private Calculator cscCalc;

    public App() {
        SinCalculator sinCalculator = new SinCalculator();
        CosCalculator cosCalculator = new CosCalculator(sinCalculator);
        this.sinCalc = sinCalculator;
        this.cosCalc = cosCalculator;
        this.tanCalc = new TanCalculator(sinCalculator, cosCalculator);
        this.cotCalc = new CotCalculator(sinCalculator, cosCalculator);
        this.secCalc = new SecCalculator(cosCalculator);
        this.cscCalc = new CscCalculator(sinCalculator);
    }

    public double calculateFunction(double x, double epsilon) {
        try {
            double sinX = sinCalc.calc(x, epsilon);
            double cosX = cosCalc.calc(x, epsilon);
            double tanX = tanCalc.calc(x, epsilon);
            double cotX = cotCalc.calc(x, epsilon);
            double secX = secCalc.calc(x, epsilon);
            double cscX = cscCalc.calc(x, epsilon);

            double A = (secX + cscX) / cotX;
            double B = cscX + cotX;
            double C = A * B * cscX * cosX;
            double D = (cotX + cosX) * Math.pow(cosX, 2) - cscX;
            double E = Math.pow(D, 3);
            double F = (Math.pow(C, 2) + E) / tanX;
            double G = cosX - sinX;
            double H = cscX + cscX + Math.pow(cotX, 2);
            double I = (G + H) * cosX;
            double J = Math.pow(I, 2) * (tanX + sinX);
            double K = (((cotX - sinX) * cosX) - Math.pow(sinX, 2)) * (tanX - cotX) / (tanX * sinX);
            double L = J / K;
            double M = Math.pow(sinX / cotX, 2);
            double N = Math.pow(Math.pow(M, 2), 2);
            return L + N;

        } catch (ArithmeticException e) {
            System.err.println("Arithmetic error: " + e.getMessage());
            return Double.NaN;
        }
    }

    public static void main(String[] args) {

    }
}
