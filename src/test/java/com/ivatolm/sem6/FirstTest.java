package com.ivatolm.sem6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.Math;

class FirstTest {
	private static final double EPS = 0.01;

	private First first;

	@BeforeEach
	void init() {
		first = new First();
	}

	@Test
	public void whenNegative() {
		assertTrue((first.run(-Math.PI / 2) - (-1)) < EPS);
	}

	@Test
	public void whenZero() {
		assertTrue((first.run(0) - (0)) < EPS);
	}

	@Test
	public void whenPositive() {
		assertTrue((first.run(Math.PI) - (1)) < EPS);
	}
}
