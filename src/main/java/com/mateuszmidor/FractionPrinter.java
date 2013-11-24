package com.mateuszmidor;

import com.google.common.base.Strings;

public abstract class FractionPrinter {
	private FractionPrinter() {
	}

	public static void println(Fraction f) {
		String numerator = String.format("%d", f.getNumerator());
		String denominator = String.format("%d", f.getDenominator());
		int maxLen = Math.max(numerator.length(), denominator.length());

		String alignedNumerator = align(numerator, maxLen);
		String alignedDenominator = align(denominator, maxLen);
		String separator = generateString("-", maxLen);

		System.out.println(alignedNumerator);
		System.out.println(separator);
		System.out.println(alignedDenominator);
	}

	private static String generateString(String string, int count) {
		return Strings.repeat(string, count);
	}

	private static String align(String denominator, int len) {
		return Strings.padStart(denominator, len, ' ');
	}
}
