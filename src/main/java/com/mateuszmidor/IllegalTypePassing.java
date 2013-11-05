package com.mateuszmidor;

import java.util.List;

public class IllegalTypePassing {

	// tutaj u�ycie list.add jest nielegalne:
	// chcemy sobie wstawic String do listy element�w pochodnych od Object
	// fajnie, je�li lista bedzie Object�w albo wlasnie String�w.
	// ale bedzie dupa, je�li to bedzie lista np. JPaneli
	// kt�re te� przecie� dziedzicz� od Object:
	// List<JPanel>a; a.add(new String("Halo halo"))
	// raczej nie wygl�da zbyt poprawnie prawda?
	public void insertSomething(List<? extends Object> list) {
		// list.add(new String());
	}

	public IllegalTypePassing() {
		System.out
				.println("Nielegalne dodawanie jakichkolwiek element�w do List<? extends Object> list\nC� wi�cej powiedzie�?");

		System.out.println();
	}
}
