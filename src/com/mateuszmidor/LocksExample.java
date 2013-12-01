package com.mateuszmidor;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.google.common.collect.Lists;

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

	static class BowLoop implements Callable<Object> {
		private Friend bower;
		private Friend bowee;

		public BowLoop(Friend bower, Friend bowee) {
			this.bower = bower;
			this.bowee = bowee;
		}

		@Override
		public Object call() throws Exception {
			Random random = new Random();
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(random.nextInt(2000));
				} catch (InterruptedException e) {
				}
				bowee.bow(bower);
			}
			return null;
		}
	}

	public LocksExample() {
		System.out.println("Concurrent locks example.");
		
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");
		
		// przygotowujemy pule dwoch w¹tków
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		// przygotwujemy listê zadañ
		List<BowLoop> tasks = Lists.newArrayList(new BowLoop(alphonse, gaston), 
				new BowLoop(gaston, alphonse));
		
		try {
			// odpalamy zadania i czekamy, a¿ zostan¹ zakoñczone
			es.invokeAll(tasks);
		} catch (InterruptedException e) {
		}
		
		// zabijamy pule w¹tków
		es.shutdown();
		System.out.println();
	}
}
