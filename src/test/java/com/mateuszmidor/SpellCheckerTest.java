package com.mateuszmidor;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class SpellCheckerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		Dictionary dict = new Dictionary("tanie", "dobre");
		SpellChecker sc = new SpellChecker(dict);
		String input = "Tanie wino jest dobre, bo jest dobre i tanie";
		String expectedOutput = "Tanie [wino] [jest] dobre, [bo] [jest] dobre [i] tanie";
		String output = sc.markErrors(input);

		Assert.assertEquals(expectedOutput, output);
	}

}
