package com.mateuszmidor;

import java.util.List;

public class Dictionaries {

	public static Dictionary fromFile(TextFileReader reader) {
		List<String> words = reader.asMultiLine();
		return new Dictionary(words);
	}

}
