package com.mateuszmidor;

import java.util.Arrays;

import com.google.common.base.Joiner;

public class JoinerExample {

	public JoinerExample() {
		System.out.println("Joiner example:");

		String[] tokens = 
			{ "Dolary", "dolary", null, "Lancwery", "lancwery", null };
		System.out.println(Arrays.asList(tokens).toString());
		
		Joiner joiner = Joiner.on(" ").useForNull("!");
		String joined = joiner.join(tokens);
		System.out.println(joined);

		System.out.println();
	}

}
