package com.mateuszmidor;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FractionPrinterTest {

	private static PrintStream printer;
	private static ByteArrayOutputStream console;
	private String eol = System.getProperty("line.separator");
	
	@BeforeClass
	public static void setup() {
		console = new ByteArrayOutputStream();
		printer = new PrintStream(console);
		
	}

	@Test
	public void testPrint() {
		System.setOut(printer);
		Fraction f = new Fraction(7, 8);
		FractionPrinter.println(f);
		Assert.assertEquals("7" + eol + "-" + eol + "8" + eol, console.toString());
	}

}
