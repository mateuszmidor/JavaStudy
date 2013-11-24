package com.mateuszmidor;

public class Fraction {
	private int numerator;
	private int denominator;

	public int getDenominator() {
		return denominator;
	}
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	public int getNumerator() {
		return numerator;
	}
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	public Fraction(int numerator, int denominator) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
	}
	public Fraction() {
		this.numerator = 0;
		this.denominator = 0;
	}

}
