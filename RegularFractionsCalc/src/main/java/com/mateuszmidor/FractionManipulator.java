package com.mateuszmidor;

public class FractionManipulator {
	public static Fraction add(Fraction a, Fraction b) {
		Fraction result = new Fraction();
		result.numerator = a.numerator + b.numerator;
		result.denominator = b.denominator + a.denominator;
		return result;
	}
}
