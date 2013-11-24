package com.mateuszmidor;

public class FractionParser {
	private FractionParser() {
	}

	public static Fraction parse(String token) {
		String[] numeratorDenominator = token.split("/");

		return new Fraction(Integer.parseInt(numeratorDenominator[0]),
				Integer.parseInt(numeratorDenominator[1]));
	}

}
