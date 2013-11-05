package com.mateuszmidor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Musi byæ retention runtime, 
// inaczej informacja o tej adnotacji przepadnie w czasie kompilacji
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@interface MyTest {

}

public class Annotations {
	@MyTest
	public void test1() {
	}

	@MyTest
	public void test2() {
	}

	public void notTest() {

	}

	public void noTest2() {
	}

	@MyTest
	public void test3() {
	}

	// Przyk³ad jak zrobiæ w³asnego JUnita - automatycze wyszukiwanie metod
	// testowych w klasie
	public Annotations() {
		System.out.println("Moje metody opatrzone adnotacj¹ @MyTest to:");
		
		for (Method m : this.getClass().getMethods()) {
			
			if (isMyTestMethod(m))
				printMethodName(m);
		}
		
		System.out.println();
	}
	
	private boolean isMyTestMethod(Method m) {
		return m.isAnnotationPresent(MyTest.class);
	}

	private void printMethodName(Method m) {
		System.out.println(m.getName());
	}

}
