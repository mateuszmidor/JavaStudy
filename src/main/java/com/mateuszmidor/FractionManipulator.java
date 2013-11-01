package com.mateuszmidor;

public class FractionManipulator {

	private static int getCommonDelimiter(Fraction a, Fraction b) {
		int commonDenominator = a.denominator * b.denominator;
		return commonDenominator;
	}

	public static Fraction add(Fraction a, Fraction b) {
		Fraction result = new Fraction();

		int commonDenominator = getCommonDelimiter(a, b);
		result.numerator = a.numerator * b.denominator + b.numerator
				* a.denominator;
		result.denominator = commonDenominator;
		return result;
	}

	public static Fraction sub(Fraction a, Fraction b) {
		Fraction result = new Fraction();

		int commonDenominator = getCommonDelimiter(a, b);
		result.numerator = a.numerator * b.denominator - b.numerator
				* a.denominator;
		result.denominator = commonDenominator;
		return result;
	}
}
