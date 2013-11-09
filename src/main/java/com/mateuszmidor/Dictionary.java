package com.mateuszmidor;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {
	private Set<String> wordList = new HashSet<>();

	public Dictionary() {
	}

	public Dictionary(String... words) {
		addWords(words);
	}

	public Dictionary(Collection<String> words) {
		addWords(words);
	}

	public void addWords(String... words) {
		addWords(Arrays.asList(words));
	}

	public void addWords(Collection<String> words) {
		for (String word : words) {
			addWord(word);
		}
	}
	
	public void addWord(String word) {
		String lowerCaseWord = word.toLowerCase();
		wordList.add(lowerCaseWord);
	}

	public boolean containsWord(String word) {
		String lowerCaseWord = word.toLowerCase();
		return wordList.contains(lowerCaseWord);
	}

}
