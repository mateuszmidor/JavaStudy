package com.mateuszmidor;

import java.util.Arrays;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public final class MultiSetExample {
	public MultiSetExample() {
		String sentence = "i wierci i wierci i szura i szura";

		System.out.println("MultiSet example.\nCounting duplicate words in:");
		System.out.println(sentence);

		Multiset<String> set = HashMultiset.create();
		set.addAll(Arrays.asList(sentence.split(" ")));
		System.out.println(set);

		System.out.println("Adding 't�ucze' with setCount(t�ucze, 10)");
		set.setCount("t�ucze", 10);
		System.out.println(set);

		System.out.println("Removing 't�ucze' with remove(t�ucze, 3)");
		set.remove("t�ucze", 3);
		System.out.println(set);

		System.out.println();
	}
}
