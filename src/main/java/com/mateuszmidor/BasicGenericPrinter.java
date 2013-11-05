package com.mateuszmidor;

public class BasicGenericPrinter {

	// funkcja printuj¹ca dowolny typ obiektowy
	public <T> void println(T item) {
		System.out.printf("%s%n", item.toString());
	}

	public BasicGenericPrinter() {
		System.out.println("Basic generic printing method");

		println(11235L);
		println(3.1415D);
		println("mateusz");
		
		System.out.println();
	}
}
