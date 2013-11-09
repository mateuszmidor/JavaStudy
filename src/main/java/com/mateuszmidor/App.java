package com.mateuszmidor;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {

		Dictionary englishDictionary = Dictionaries.fromFile(new TextFileReader("english.dic"));
		String originalText = new TextFileReader("EnglishText.txt").asSingleLine();
		SpellChecker spellChecker = new SpellChecker(englishDictionary);
		String markedErrorsText = spellChecker.markErrors(originalText);
		
		System.out.println("Program zaznacza nierozpoznane słowa w tekście.");
		System.out.println("Oryginalny tekst:");
		System.out.println(originalText);
		System.out.println();
		System.out.println("Zaznaczone nierozpoznane słowa:");
		System.out.println(markedErrorsText);
		
	
	}
}
