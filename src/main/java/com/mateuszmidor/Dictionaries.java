package com.mateuszmidor;

import java.util.List;

public class Dictionaries {

	public static Dictionary fromFile(String filename) {
		List<String> words = TextFile.asMultiLine(filename);
		return new Dictionary(words);
	}

}
