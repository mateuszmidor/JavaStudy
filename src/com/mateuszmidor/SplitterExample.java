package com.mateuszmidor;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class SplitterExample {
	public SplitterExample() {
		System.out.println("Splitter example:");
		
		String text = "Me najdro¿sze najs³odsze zielone  ! ";
		System.out.println(text);
		
		Splitter splitter = Splitter.on(" ").omitEmptyStrings().trimResults();
		Iterable<String> tokens = splitter.split(text);
		System.out.println(Lists.newArrayList(tokens));
		
		System.out.println();
	}
}
