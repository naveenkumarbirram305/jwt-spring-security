package com.example.demo.ct.dsa;

import java.util.HashMap;
import java.util.Hashtable;

public class SimpleHashTable {
	private Employee[] hashtable;

	public SimpleHashTable() {
		hashtable = new Employee[10];
	}

	public void put(String key, Employee emp) {
		int hashingKey = hashKey(key);
		if (hashtable[hashingKey] != null) {
			System.out.println("Sorry, Already employee exist!");
		} else {
			hashtable[hashingKey] = emp;
		}
	}

	public Employee get(String key) {
		int hashingKey = hashKey(key);
		return hashtable[hashingKey];
	}

	public void printHashTable() {
		for (int i = 0; i < hashtable.length; i++) {
			System.out.println(hashtable[i]);
		}
	}
	
	public void checkHashTable() {
		HashMap<String, String> tab = new HashMap<>();
		tab.put("Naveen", "NKNK");
		tab.put("Kumar", "KMKM");
		tab.put("Naveen", "llll");
//		for (int i = 0; i < tab.size(); i++) {
//			System.out.println(tab.get(i));
//		}
		System.out.println(tab.get("Naveen"));
		

	}

	/**
	 * This is very basic hashing technique
	 * 
	 * @param key
	 * @return
	 */
	private int hashKey(String key) {
		return key.length() % hashtable.length;
	}
}
