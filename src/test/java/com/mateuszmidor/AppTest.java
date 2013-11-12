package com.mateuszmidor;

import java.lang.reflect.Method;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	@Test
	public void testClassAnnotation() {
		Assert.assertTrue(App.class.isAnnotationPresent(ClassDescriptor.class));

		ClassDescriptor annotation = App.class
				.getAnnotation(ClassDescriptor.class);
		Assert.assertEquals("Main class", annotation.purpose());
	}

	@Test
	public void testMainMethodAnnotation() {
		try {
			Method m = App.class.getMethod("main", String[].class);
			Assert.assertTrue(m.isAnnotationPresent(MethodDescriptor.class));
			
			MethodDescriptor annotation = m.getAnnotation(MethodDescriptor.class);
			Assert.assertEquals("Mateusz", annotation.author());
			Assert.assertEquals("Application entry point", annotation.description());
			
		} catch (NoSuchMethodException e) {
			System.err.println("Brak metody main w aplikacji");
		} catch (SecurityException e) {
			System.err.println("Brak dostêpu do metody main");
		}

	}
}
