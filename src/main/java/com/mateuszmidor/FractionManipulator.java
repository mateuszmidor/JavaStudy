package com.mateuszmidor;

public class FractionManipulator {
	private FractionManipulator() {
	}

	private static int getCommonDelimiter(Fraction a, Fraction b) {
		return a.getDenominator() * b.getDenominator();
	}

	public static Fraction add(Fraction a, Fraction b) {
		Fraction result = new Fraction();

		int commonDenominator = getCommonDelimiter(a, b);
		result.setNumerator(a.getNumerator() * b.getDenominator()
				+ b.getNumerator() * a.getDenominator());
		result.setDenominator(commonDenominator);
		return result;
	}

	public static Fraction sub(Fraction a, Fraction b) {
		Fraction result = new Fraction();

		int commonDenominator = getCommonDelimiter(a, b);
		result.setNumerator(a.getNumerator() * b.getDenominator()
				- b.getNumerator() * a.getDenominator());
		result.setDenominator(commonDenominator);
		return result;
	}
}
