package com.mateuszmidor;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocksExample {

	static class Friend {
		private final String name;
		private final Lock lock = new ReentrantLock();

		public Friend(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		// sprawdzamy, czy mo¿na siê uk³oniæ
		// bez ryzyka deadlocku
		public boolean impendingBow(Friend bower) {
			boolean mylock = false;
			boolean hislock = false;

			// spróbujmy pobraæ locki dla siebie i kolegi
			mylock = lock.tryLock();
			hislock = bower.lock.tryLock();

			// nie uda³o siê - odblokowujemy
			if (!(mylock && hislock)) {
				if (mylock)
					lock.unlock();

				if (hislock)
					bower.lock.unlock();
			}

			return mylock && hislock;
		}

		public void bow(Friend bower) {
			if (impendingBow(bower)) {
				System.out
						.printf("%s: %s has bowed to me!%n", name, bower.name);
				bower.bowBack(this);
			} else {
				System.out
						.printf("%s: %s started to bow to me, but saw that I was already bowing to him%n",
								name, bower.name);
			}

		}

		private void bowBack(Friend friend) {
			System.out.printf("%s: %s bowed back to me!%n", name, friend.name);
		}
	}

	static class BowLoop implements Runnable {
		private Friend bower;
		private Friend bowee;

		public BowLoop(Friend bower, Friend bowee) {
			this.bower = bower;
			this.bowee = bowee;
		}

		public void run() {
			Random random = new Random();
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(random.nextInt(2000));
				} catch (InterruptedException e) {
				}
				bowee.bow(bower);
			}
		}
	}

	public LocksExample() {
		System.out.println("Concurrent locks example.");
		
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");
		Thread friend1 = new Thread(new BowLoop(alphonse, gaston));
		friend1.start();
		
		Thread friend2 = new Thread(new BowLoop(gaston, alphonse));
		friend2.start();
		
		// czekamy, a¿ sie ch³opaki znudz¹ uk³onami
		try {
			friend1.join();
			friend2.join();
		} catch (InterruptedException e) {
		}
		
		System.out.println();
	}
}
