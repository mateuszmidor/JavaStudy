package com.mateuszmidor;

import com.google.common.base.CharMatcher;

public class CharMatcherExample {
	public CharMatcherExample() {
		System.out.println("CharMatcher example:");

		String text = "4 razy po 2 razy, 8 razy raz po raz";
		System.out.println(text);

		System.out.println("Remove digits:");
		System.out.println(CharMatcher.DIGIT.removeFrom(text));
		System.out.println("Retain digts only:");
		System.out.println(CharMatcher.DIGIT.retainFrom(text));
		System.out.println("Remove colons:");
		System.out.println(CharMatcher.is(',').removeFrom(text));
		System.out.println("Replace digits with text:");
		System.out.println(CharMatcher.DIGIT.replaceFrom(text, "ileœ"));

		System.out.println();
	}
	

}
