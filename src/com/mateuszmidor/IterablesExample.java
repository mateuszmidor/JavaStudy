package com.mateuszmidor;

import java.util.List;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class IterablesExample {
	public IterablesExample() {
		System.out.println("Iterables example.\nConcat lists:");
		List<Integer> first = Lists.newArrayList(1, 2, 3);
		List<Integer> second = Lists.newArrayList(4, 5, 6);
		List<Integer> third = Lists.newArrayList(7, 8, 9);
		System.out.println("first  " + first);
		System.out.println("second " + second);
		System.out.println("third  " + third);

		Iterable<Integer> all = Iterables.concat(first, second, third);
		System.out.println(all);
		
		System.out.println("add '10' to third");
		third.add(10);
		System.out.println(all);
		System.out.println();

	}
}
