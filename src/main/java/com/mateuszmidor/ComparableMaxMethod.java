package com.mateuszmidor;

public class ComparableMaxMethod {
	
	// ta funkcja dzia³a tylko na obiektach rozszerzaj¹cych Comparable
	public <T extends Comparable<T>> T max(T a, T b, T c) {
		
		T m = a;
		
		if (b.compareTo(m) > 0)
			m = b;
		
		if (c.compareTo(m) > 0)
			m = c;
		
		return m;
	}
	
	public ComparableMaxMethod() {
		System.out.println("T extends Comparable - max(a, b, c) method");
		
		Integer maxi = max(3, 1, 2);
		System.out.printf("Max of [3, 1, 2] is %d%n", maxi);
		
		Character maxc = max('b', 'c', 'a');
		System.out.printf("Max of [b, c, a] is %c%n", maxc);
		
		System.out.println();
	}
}
