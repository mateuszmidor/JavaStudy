package com.mateuszmidor;

import java.lang.reflect.Field;

class SecretData {

	@SuppressWarnings("unused")
	private int secretInt = 123;

	public SecretData(int secretInt) {
		super();
		this.secretInt = secretInt;
	}
}

public class PrivateFieldAccess {

	public PrivateFieldAccess() {
		System.out.println("Zawartoœæ prywatnego pola secretInt to:");

		Field privateField = null;
		SecretData secretHolder = new SecretData(123);
		try {
			privateField = SecretData.class.getDeclaredField("secretInt");
			privateField.setAccessible(true);
			System.out.format("%d\n", privateField.getInt(secretHolder));
		
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();
		
	}

}
