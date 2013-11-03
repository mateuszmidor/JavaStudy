package com.mateuszmidor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


class Calculator {
	public int add(int a, int b) {
		System.out.format("metoda add odpalona z parametrami %d i %d!\n", a, b);
		return a + b;
	}
}

public class MethodInvocation {

	public MethodInvocation() {
		System.out.println("Refleksyjnie odpalamy metode add kalkulatora:");
		
		try {
			Method m = Calculator.class.getMethod("add", int.class, int.class);
			m.invoke(new Calculator(), 10, 40);
		
		
		} catch (NoSuchMethodException | SecurityException e) {
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
		}
		
		System.out.println();
	}

}
