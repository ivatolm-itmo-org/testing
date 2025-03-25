package com.ivatolm.sem6.first;

import java.lang.Math;

public class First {
	public double run(double x) {
		return x - Math.pow(x, 3) / 6 + Math.pow(x, 5) / 120 - Math.pow(x, 7) / 5040;
	}
}

