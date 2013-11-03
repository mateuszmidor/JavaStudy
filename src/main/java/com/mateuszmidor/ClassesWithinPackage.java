package com.mateuszmidor;

import java.util.Set;

import org.reflections.Reflections;

public class ClassesWithinPackage {

	public ClassesWithinPackage() {
		System.out.println("Klasy w pakiecie com.mateuszmidor to:");

		Reflections reflections = new Reflections("com.mateuszmidor");
		Set<Class<? extends Object>> allClasses = reflections
				.getSubTypesOf(Object.class);

		for (Class<? extends Object> c : allClasses) {
			System.out.println(c.getName());
		}
		
		System.out.println();
	}

}
