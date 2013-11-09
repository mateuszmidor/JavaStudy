package com.mateuszmidor;

import java.util.StringTokenizer;

public class SpellChecker {

	// delimitery nie będą zaznaczone jako nieznane słowa/znaki
	private static final String DELIMITERS = " ,.;:\"'\\()[]{}1234567890+-=!\r\n";
	private Dictionary dict;
	
	public SpellChecker(Dictionary dictionary) {
		dict = dictionary;
	}
	
	public String markErrors(String text) {

		StringTokenizer st = new StringTokenizer(text, DELIMITERS, true);
		StringBuilder sb = new StringBuilder();
		
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			String output;
			
			if (isDelimiter(token)) {
				output = token;
			} else {
				output = markWordIfIncorrect(token);
			}
			sb.append(output);
			
		}
		return sb.toString();
	}

	private String markWordIfIncorrect(String word) {
		if (dict.containsWord(word))
			return word;
		else
			return String.format("[%s]", word);
	}

	private boolean isDelimiter(String token) {
		return DELIMITERS.contains(token);
	}

}
