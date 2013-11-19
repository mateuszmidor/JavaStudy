package com.mateuszmidor;

import com.google.common.base.Preconditions;

public class PreconditionsExample {
	private class PreconditionsTest {

		public PreconditionsTest(int userId, String userName) {
			Preconditions.checkNotNull(userName, "userName can not be null");
			System.out.println("Creating user " + userName);
			Preconditions.checkArgument(userName.length() <= 12,
					"userName can not be longer than 12 characters");
		}

	}

	public PreconditionsExample() {
		System.out.println("Preconditions example.");

		try {
			new PreconditionsTest(50, "Konstantynopolitanczykiewiczowianeczka");
		} catch (Exception e) {
			System.out.println("Exception thrown:");
			System.out.println(e.getMessage());
			
		}
		System.out.println();
	}
}
