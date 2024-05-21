package com.example.demo.ct.dsa;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates the behavior of ArrayList without thread-safety. - Two threads
 * concurrently add elements to a shared ArrayList. - Shows that ArrayList is
 * not thread-safe and can lead to data corruption.
 */
public class ArrayListExample {
	public static void main(String[] args) {
		// Create a shared list
		List<Integer> list = new ArrayList<>();

		// Create and start two threads accessing the list
		Thread thread1 = new Thread(() -> {
			// Thread 1 adds elements to the list from 0 to 999
			for (int i = 0; i < 1000; i++) {
				list.add(i); // Add elements to the list
			}
		});

		Thread thread2 = new Thread(() -> {
			// Thread 2 adds elements to the list from 1000 to 1999
			for (int i = 1000; i < 2000; i++) {
				list.add(i); // Add elements to the list
			}
		});

		thread1.start();
		thread2.start();

		// Wait for both threads to finish
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Print the size of the list
		System.out.println("Size of ArrayList: " + list.size());
	}
}
