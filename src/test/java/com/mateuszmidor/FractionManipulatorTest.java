package com.mateuszmidor;

import org.junit.Assert;
import org.junit.Test;

public class FractionManipulatorTest {

	// @Ignore
	@Test
	public void testAdd() {
		Fraction a = new Fraction(1, 2);
		Fraction b = new Fraction(2, 2);
		Fraction sum = FractionManipulator.add(a, b);
		Assert.assertEquals(1.5f, (float)sum.getNumerator() / sum.getDenominator(), 0.01);
	}

}
