package com.ivatolm.sem6.functions;

public class Utils {
    public static double normalizeAngle(double x) {
        x = x % (2 * Math.PI);
        if (x > Math.PI) x -= 2 * Math.PI;
        else if (x < -Math.PI) x += 2 * Math.PI;
        return x;
    }
}
