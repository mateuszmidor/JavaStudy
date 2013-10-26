package com.mateuszmidor;

import junit.framework.Assert;

import org.junit.Test;

public class FractionSimplifierTest {

	@Test
	public void testSimplify() {
		Fraction complex = new Fraction(4, 6);
		Fraction simplified = FractionSimplifier.simplify(complex);
		Assert.assertEquals(2, simplified.numerator);
		Assert.assertEquals(3, simplified.denominator);
	}

}
