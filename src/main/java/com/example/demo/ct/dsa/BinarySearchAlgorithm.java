package com.example.demo.ct.dsa;

public class BinarySearchAlgorithm {

	public static void main(String[] args) {
		int binarySearch = binarySearch(20);
		System.out.println(binarySearch);
	}
	
	public static int binarySearch(int value) {
		int[] intArray = {-22, -15, 1, 7, 20, 35, 55};
		int midPoint = intArray.length/2;
		if(intArray[midPoint] == value) {
			return intArray[midPoint];
		}else {
			if(intArray[midPoint] > value) {
				for(int i =midPoint; i>=0; i--) {
					if(intArray[i] == value) {
						return intArray[i];
					}
				}
			}else {
				for(int i =midPoint; i<=intArray.length; i++) {
					if(intArray[i] == value) {
						return intArray[i];
					}
				}
			}
		}
		return midPoint;
		
	}

}
