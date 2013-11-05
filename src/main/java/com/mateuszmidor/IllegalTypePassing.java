package com.mateuszmidor;

import java.util.List;

public class IllegalTypePassing {

	// tutaj u¿ycie list.add jest nielegalne:
	// chcemy sobie wstawic String do listy elementów pochodnych od Object
	// fajnie, jeœli lista bedzie Objectów albo wlasnie Stringów.
	// ale bedzie dupa, jeœli to bedzie lista np. JPaneli
	// które te¿ przecie¿ dziedzicz¹ od Object:
	// List<JPanel>a; a.add(new String("Halo halo"))
	// raczej nie wygl¹da zbyt poprawnie prawda?
	public void insertSomething(List<? extends Object> list) {
		// list.add(new String());
	}

	public IllegalTypePassing() {
		System.out
				.println("Nielegalne dodawanie jakichkolwiek elementów do List<? extends Object> list\nCó¿ wiêcej powiedzieæ?");

		System.out.println();
	}
}
