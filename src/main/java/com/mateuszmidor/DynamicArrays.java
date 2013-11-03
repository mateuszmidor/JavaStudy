package com.mateuszmidor;

import java.lang.reflect.Array;

public class DynamicArrays {
	public DynamicArrays() {
		System.out.println("Generujemy tablice na podstawie nazw typów, z uzyciem Array.newInstance(). Oto wynik:");
		
		String[] types = { "java.lang.Integer", "java.lang.Float",
				"java.lang.Double" };

		int size = 15;
		for (String type : types) {
			Number[] array = createArray(type, size);
			System.out.format("Typ: %s,  dlugosc: %d\n", array.getClass()
					.getSimpleName(), Array.getLength(array));
			size += 5;
		}
		
		System.out.println();
	}

	private Number[] createArray(String type, int size) {
		Class<?> class_ = null;
		try {
			class_ = Class.forName(type);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Number[]) Array.newInstance(class_, size);
	}
}
