package com.mateuszmidor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Loudy {
	public Loudy() {
		System.out.println("Loudy sie narodzi³ idziêki refleksyjnej metodzie constructor.newInstance()!");
		System.out.println();
	}
}

public class NewInstanceWithConstructor {

	@SuppressWarnings("unused")
	public NewInstanceWithConstructor() {
		try {
			Class<?> class_ = Loudy.class;
			Constructor<?> c = class_.getConstructor();
			Object o = c.newInstance();
			
		} catch (NoSuchMethodException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
	}
}
