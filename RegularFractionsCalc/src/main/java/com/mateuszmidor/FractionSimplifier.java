package com.mateuszmidor;

public class FractionSimplifier {
	private static boolean dividesBy(int number, int divisor) {
		return (number % divisor) == 0;
	}

	public static Fraction simplify(Fraction f) {
		for (int i = f.denominator; i > 1; i--) {
			if (dividesBy(f.numerator, i) && dividesBy(f.denominator, i)) {
				return new Fraction(f.numerator / i, f.denominator / i);
			}
		}
		return f;
	}

}
