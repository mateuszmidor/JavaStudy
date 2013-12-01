package com.mateuszmidor;

import java.util.Iterator;
import java.util.Random;

import com.google.common.collect.Iterators;

class DropBox {
	private boolean empty = true;
	private String product;

	public synchronized void put(final String s) {
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		empty = false;
		product = s;
		notify();
	}

	public synchronized String get() {
		while (empty) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}

		empty = true;
		notify();
		return product;
	}
}

class Producer implements Runnable {

	private DropBox db;

	public Producer(DropBox db) {
		this.db = db;
	}

	@Override
	public void run() {
		// iterator cykliczny - krêci sie w kó³ko
		Iterator<String> iterator = Iterators.cycle("Mares eat oats",
				"Does eat oats", "Little lambs eat ivy",
				"A kid will eat ivy too");

		Random random = new Random();

		while (iterator.hasNext()) {
			db.put(iterator.next());
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
			}
		}
		db.put("DONE");

	}
}

class Consumer implements Runnable {

	private DropBox db;
	public Consumer(DropBox db) {
		this.db = db;
	}

	@Override
	public void run() {
		Random random = new Random();
		for (String message = db.get(); 
				!message.equals("DONE"); message = db.get()) {
			
			System.out.format("MESSAGE RECEIVED: %s%n", message);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
			}
		}
	}

}

public class WaitNotifyExample {

	public WaitNotifyExample() {

		// Drop box pozwala wrzucaæ i wyci¹gaæ tekst
		// w sposób synchronizowany
		DropBox drop = new DropBox();
		
		// producent wrzuca tekst co jakiœ czas
		(new Thread(new Producer(drop), "producer")).start();
		
		// konsument pobiera i wyœwietla tekst co jakiœ czas
		(new Thread(new Consumer(drop), "consumer")).start();

	}
}