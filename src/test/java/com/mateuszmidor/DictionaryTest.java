package com.mateuszmidor;

import junit.framework.Assert;

import org.junit.Test;

public class DictionaryTest {

	@Test
	public void test() {
		Dictionary dict = new Dictionary("KROWA", "koza", "Kot", "kOŃ");
		Assert.assertTrue(dict.containsWord("krowa"));
		Assert.assertTrue(dict.containsWord("Koza"));
		Assert.assertTrue(dict.containsWord("Kot"));
		Assert.assertTrue(dict.containsWord("koń"));
	}

}
