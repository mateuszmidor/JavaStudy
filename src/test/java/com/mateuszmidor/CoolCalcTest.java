package com.mateuszmidor;

import junit.framework.Assert;

import org.junit.Test;

public class CoolCalcTest {

	@Test
	public void testCalc() {
		Fraction result = CoolCalc.calc("2/5+3/5 - 5/10");
		Assert.assertEquals(0.5f, (float)result.getNumerator() / result.getDenominator(), 0.01);
	}
	
	@Test(expected=RuntimeException.class)
	public void testUnhandledOperatorCalc() {
		Fraction result = CoolCalc.calc("2/1 * 2/1");
		Assert.assertEquals(0.5f, (float)result.getNumerator() / result.getDenominator(), 0.01);
	}

}
