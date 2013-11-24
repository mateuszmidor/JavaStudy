package com.mateuszmidor;

public class FractionSimplifier {
	private FractionSimplifier() {
	}
	private static boolean dividesBy(int number, int divisor) {
		return (number % divisor) == 0;
	}

	public static Fraction simplify(Fraction f) {
		for (int i = f.getDenominator(); i >= 2; i--) {
			if (dividesBy(f.getNumerator(), i)
					&& dividesBy(f.getDenominator(), i)) {
				return new Fraction(f.getNumerator() / i, f.getDenominator()
						/ i);
			}
		}
		return f;
	}

}
