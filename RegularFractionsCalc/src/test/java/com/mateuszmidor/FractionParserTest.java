package com.mateuszmidor;

import junit.framework.Assert;

import org.junit.Test;

public class FractionParserTest {

	@Test
	public void test() {
		Fraction f = FractionParser.parse("15/16");
		Assert.assertEquals(15, f.numerator);
		Assert.assertEquals(16, f.denominator);
	}

}
