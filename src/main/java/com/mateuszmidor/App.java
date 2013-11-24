package com.mateuszmidor;

import java.util.Scanner;

/**
 * Hello world!
 * 
 */
public class App {
	private App() {
	}

	public static void main(String[] args) {
		printWelcomeMessageWithInstructions();

		String s = readln();
		while (!shouldExit(s)) {
			if (isCorrectEquation(s)) {
				Fraction f = FractionSimplifier.simplify(CoolCalc.calc(s));
				FractionPrinter.println(f);
				println("");
			}
			s = readln();
		}

		printByeByeMessage();
	}

	private static boolean isCorrectEquation(String s) {
		return (null != s) && (!s.isEmpty());
	}

	private static String readln() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in, "UTF-8");
		return s.nextLine();
	}

	private static boolean shouldExit(String s) {
		return "q".equals(s);
	}

	private static void printByeByeMessage() {
		println("Bye bye!");
	}

	private static void printWelcomeMessageWithInstructions() {
		println("Kalkulator. Wpisz wyrazenie typu 1/2+4/5-7/8. [q-quit]");
	}

	private static void println(String string) {
		System.out.println(string);
	}
}
