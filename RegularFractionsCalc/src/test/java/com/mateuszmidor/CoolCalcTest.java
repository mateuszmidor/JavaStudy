package com.mateuszmidor;

import junit.framework.Assert;

import org.junit.Test;

public class CoolCalcTest {

	@Test
	public void testCalc() {
		Fraction result = CoolCalc.calc("2/5+3/5 - 5/10");
		Assert.assertEquals(0.5f, (float)result.numerator / result.denominator, 0.01);
	}

}
