package com.example.demo.ct.dsa;

import java.util.Vector;

/**
 * Demonstrates the behavior of Vector with thread-safety. - Two threads
 * concurrently add elements to a shared Vector. - Shows that Vector is
 * thread-safe and prevents data corruption.
 */
public class VectorExample {
	public static void main(String[] args) {
		// Create a shared vector
		Vector<Integer> vector = new Vector<>();

		// Create and start two threads accessing the vector
		Thread thread1 = new Thread(() -> {
			// Thread 1 adds elements to the vector from 0 to 999
			for (int i = 0; i < 1000; i++) {
				vector.add(i); // Add elements to the vector
			}
		});

		Thread thread2 = new Thread(() -> {
			// Thread 2 adds elements to the vector from 1000 to 1999
			for (int i = 1000; i < 2000; i++) {
				vector.add(i); // Add elements to the vector
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

		// Print the size of the vector
		System.out.println("Size of Vector: " + vector.size());
	}
}
