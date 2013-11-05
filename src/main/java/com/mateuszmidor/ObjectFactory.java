package com.mateuszmidor;

class Shouter {
	public Shouter() {
		System.out.println("Shouter stworzony przez ObjectFactory!!!");
	}
}

public class ObjectFactory {
	public <T> T newInstance(Class<T> c) {
		try {
			return c.newInstance();

		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ObjectFactory() {
		System.out.println("Tworzenie obiektów klasy przekazanej jako parametr Class<T> do ObjectFactory");
		newInstance(Shouter.class);
		
		System.out.println();
	}
}
