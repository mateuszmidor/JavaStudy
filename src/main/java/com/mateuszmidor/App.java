package com.mateuszmidor;

/**
 * Hello world!
 * 
 */

public class App {

	public static void print(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {

		new Annotations();
		new ClassesWithinPackage();
		new PrivateFieldAccess();
		new MethodInvocation();
		new NewInstanceWithConstructor();
		new DynamicArrays();
	}
}
