package com.mateuszmidor;

import java.util.StringTokenizer;

public class CoolCalc {
	private CoolCalc() {
	}

	// "2/5 + 1/5 + 4/3 - 2/3"
	// presumption: there is at least one fraction in equation
	public static Fraction calc(String equation) {
		String cleanEquation = cleanTheEquation(equation);

		StringTokenizer st = new StringTokenizer(cleanEquation, "+-", true);

		Fraction result = FractionParser.parse(st.nextToken());
		while (st.hasMoreTokens()) {
			 // equation operator
			String operator = st.nextToken();
			Fraction fraction = FractionParser.parse(st.nextToken());

			result = doSimpleEquation(result, fraction, operator);
		}
		return result;
	}

	private static Fraction doSimpleEquation(Fraction a, Fraction b,
			String operator) {

		switch (operator) {
			case "+" :
				return FractionManipulator.add(a, b);
			case "-" :
				return FractionManipulator.sub(a, b);
			default :
				throw new UnsupportedOperationException("Nieznana operacja: " + operator);
		}
	}

	private static String cleanTheEquation(String equation) {
		return equation.replaceAll("\\s", "");
	}

}
