package com.mateuszmidor;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new WaitNotifyExample(); // producer consument cliche, Runnable&Thread
		new LocksExample(); // bow-bow back, Callable&ExecutorService
	}

}
