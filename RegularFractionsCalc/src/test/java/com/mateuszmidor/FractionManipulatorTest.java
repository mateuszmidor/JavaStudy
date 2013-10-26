package com.mateuszmidor;

import org.junit.Assert;
import org.junit.Test;

public class FractionManipulatorTest {

	// @Ignore
	@Test
	public void testAdd() {
		Fraction a = new Fraction(1, 2);
		Fraction b = new Fraction(5, 6);
		Fraction sum = FractionManipulator.add(a, b);
		Assert.assertEquals(6, sum.numerator);
		Assert.assertEquals(8, sum.denominator);
	}

}
