package com.ivatolm.sem6.functions;

import com.ivatolm.sem6.Calculator;

public class SinCalculator implements Calculator {
  @Override
  public double calc(double x, double epsilon) {
    x = Utils.normalizeAngle(x);
    double result = 0;
    double term = x;
    int n = 1;
    while (Math.abs(term) > epsilon) {
      result += term;
      term *= -x * x / ((2 * n) * (2 * n + 1));
      n++;
    }
    return result;
  }
}
