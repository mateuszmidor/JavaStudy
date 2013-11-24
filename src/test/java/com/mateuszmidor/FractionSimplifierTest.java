package com.mateuszmidor;

import junit.framework.Assert;

import org.junit.Test;

public class FractionSimplifierTest {

	@Test
	public void testSimplify1() {
		Fraction complex = new Fraction(2, 1);
		Fraction simplified = FractionSimplifier.simplify(complex);
		Assert.assertEquals(2, simplified.getNumerator());
		Assert.assertEquals(1, simplified.getDenominator());
	}
	
	@Test
	public void testSimplify2() {
		Fraction complex = new Fraction(22, 33);
		Fraction simplified = FractionSimplifier.simplify(complex);
		Assert.assertEquals(2, simplified.getNumerator());
		Assert.assertEquals(3, simplified.getDenominator());
	}

	@Test
	public void testSimplify3() {
		Fraction complex = new Fraction(2, 4);
		Fraction simplified = FractionSimplifier.simplify(complex);
		Assert.assertEquals(1, simplified.getNumerator());
		Assert.assertEquals(2, simplified.getDenominator());
	}
}
