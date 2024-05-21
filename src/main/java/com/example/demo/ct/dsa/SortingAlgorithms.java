package com.example.demo.ct.dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingAlgorithms {

	/**
	 * The main method is the entry point of the Java application. It demonstrates
	 * the usage of different sorting algorithms by calling their respective
	 * methods.
	 * 
	 * @param args command-line arguments (not used in this example)
	 */
	public static void main(String[] args) {
		bubbleSort();

		selectionSort();

		insertionSort();

		shellSort();

		bucketSort();
	}

	/**
	 * Sorts an array of integers using the Bubble Sort algorithm.
	 * 
	 * Bubble Sort is a simple sorting algorithm that repeatedly steps through the
	 * list, compares adjacent elements, and swaps them if they are in the wrong
	 * order. The pass through the list is repeated until the list is sorted. The
	 * algorithm gets its name from the way smaller elements "bubble" to the top of
	 * the list.
	 * 
	 * This method sorts the array of integers in ascending order.
	 * 
	 * @param intArray the array of integers to be sorted using the Bubble Sort
	 *                 algorithm
	 */
	public static void bubbleSort() {
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
		for (int lastIndexOfUnSortedArr = intArray.length - 1; lastIndexOfUnSortedArr > 0; lastIndexOfUnSortedArr--) {
			for (int i = 0; i < lastIndexOfUnSortedArr; i++) {
				// for ASC==> intArray[i] > intArray[i + 1]
				// for DESC==> intArray[i] < intArray[i + 1]
				if (intArray[i] > intArray[i + 1]) {
					swap(intArray, i, i + 1);
				}
			}
		}
		print("bubbleSort", intArray);
	}

	public static void swap(int[] intArray, int i, int j) {
		if (i == j) {
			return;
		}
		int temp = intArray[i];
		intArray[i] = intArray[j];
		intArray[j] = temp;
	}

	/**
	 * Sorts an array of integers using the Selection Sort algorithm.
	 * 
	 * Selection Sort is a simple sorting algorithm that works by repeatedly finding
	 * the minimum (or maximum) element from the unsorted part of the array and
	 * putting it at the beginning (or end) of the sorted part. The algorithm
	 * maintains two subarrays: one that is already sorted and another one that is
	 * unsorted. It iterates over the unsorted subarray, finds the minimum (or
	 * maximum) element, and swaps it with the first element of the unsorted
	 * subarray. This process is repeated until the entire array is sorted.
	 * 
	 * This method sorts the array of integers in ascending order.
	 * 
	 * @param intArray the array of integers to be sorted using the Selection Sort
	 *                 algorithm
	 */
	public static void selectionSort() {
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
		for (int lastIndexOfUnSortedArr = intArray.length - 1; lastIndexOfUnSortedArr > 0; lastIndexOfUnSortedArr--) {
			int largest = 0;
			for (int i = 1; i <= lastIndexOfUnSortedArr; i++) {
				if (intArray[i] > intArray[largest]) {
					largest = i;
				}
			}
			swap(intArray, lastIndexOfUnSortedArr, largest);
		}
		print("selectionSort", intArray);

	}

	/**
	 * Sorts an array of integers using the Insertion Sort algorithm.
	 * 
	 * Insertion Sort is a simple sorting algorithm that builds the final sorted
	 * array one item at a time. It iterates over the array and at each iteration,
	 * it removes one element from the input data, finds the location it belongs
	 * within the sorted list, and inserts it there. This process is repeated until
	 * the entire array is sorted.
	 * 
	 * This method sorts the array of integers in ascending order.
	 * 
	 * @param intArray the array of integers to be sorted using the Insertion Sort
	 *                 algorithm
	 */
	public static void insertionSort() {
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
		for (int firstUnSortedIndex = 1; firstUnSortedIndex < intArray.length; firstUnSortedIndex++) {
			int newElement = intArray[firstUnSortedIndex];
			int i;
			for (i = firstUnSortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
				intArray[i] = intArray[i - 1];
			}
			intArray[i] = newElement;
		}
		print("insertionSort", intArray);

	}

	/**
	 * Sorts an array of integers using the Shell Sort algorithm.
	 * 
	 * Shell Sort is an efficient sorting algorithm that is based on the insertion
	 * sort algorithm. It starts by sorting pairs of elements far apart from each
	 * other, then progressively reducing the gap between elements to be compared
	 * and swapped. The algorithm uses a sequence of decreasing gaps to sort the
	 * elements, known as the increment sequence. Once the gap becomes 1, the
	 * algorithm becomes equivalent to the insertion sort algorithm, but by this
	 * time, the array has been partially sorted, resulting in better performance.
	 * 
	 * This method sorts the array of integers in ascending order.
	 * 
	 * @param intArray the array of integers to be sorted using the Shell Sort
	 *                 algorithm
	 */
	public static void shellSort() {
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
		for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < intArray.length; i++) {
				int newElement = intArray[i];
				int j = i;
				while (j >= gap && intArray[j - gap] > newElement) {
					intArray[j] = intArray[j - gap];
					j -= gap;
				}
				intArray[j] = newElement;
			}
		}
		print("shellSort", intArray);
	}

	/**
	 * A helper method to print the sorted array.
	 * 
	 * @param methodName the name of the sorting method used
	 * @param array      the sorted array of integers to be printed
	 */
	private static void print(String methodName, int[] array) {
		System.out.print(methodName + " : [");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	private static void bucketSort() {
		int[] input = { 20, 35, -15, 7, 55, 1, -22 };

		List<Integer>[] buckets = new List[10];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<>();
		}
		for (int i = 0; i < input.length; i++) {
			buckets[hash(input[i])].add(input[i]);
		}
		for (List i : buckets) {
			Collections.sort(i);
		}
		int j = 0;
		for (int i = 0; i < buckets.length; i++) {
			for (int value : buckets[i]) {
				input[j++] = value;
			}
		}
		print("bucketSort", input);
	}

	private static int hash(int i) {
		return i % (int) i;
	}

}
