package com.example.demo.ct.dsa;

public class Main {

	public static void main(String[] args) {
//		singlyLinkedList();
//		doublyLinkedList();
//		stackArray();
//		linkedStack();
//		stackChallenge();
//		arrayQueue();
//		queueChallenge();
		hashTable();
	}

	private static void doublyLinkedList() {
		DoublyLinkedList doblyLinkedList = new DoublyLinkedList();
		Employee emp1 = new Employee("Naveen", "Kumar", 123);
		Employee emp2 = new Employee("NK", "MN", 456);
		Employee emp2Duplicate = new Employee("Birram", "MN", 456);
		Employee emp4 = new Employee("Birram", "NK", 333);
		doblyLinkedList.addToTail(emp1);
//		doblyLinkedList.addToFront(emp2);
		doblyLinkedList.addToTail(emp2);
		doblyLinkedList.addToTail(emp2Duplicate);
//		doblyLinkedList.addToTail();
//		doblyLinkedList.removeFront();
//		doblyLinkedList.removeEnd();
//		doblyLinkedList.addBefore(emp2Duplicate);
//		doblyLinkedList.addBefore(emp4);
//		doblyLinkedList.print();
	}

	public static void singlyLinkedList() {
		EmployeeLinkedList sinlgeLinkedList = new EmployeeLinkedList();
		Employee emp1 = new Employee("Naveen", "Kumar", 123);
		Employee emp2 = new Employee("NK", "MN", 456);
		Employee emp3 = new Employee("Birram", "NK", 333);
		Employee empDuplicate = new Employee("Birram", "NK", 333);
//		sinlgeLinkedList.addToLast(emp1);
//		sinlgeLinkedList.addToLast(emp2);
//		list.print();

		System.out.println("Size of the List : " + sinlgeLinkedList.getSize());
//		list.removeFront();
//		list.print();
//		list.removeByIndex(123);
//		list.print();
//		sinlgeLinkedList.addToFront(emp1);
//		sinlgeLinkedList.addToFront(emp2);
//		sinlgeLinkedList.addToFront(emp3);
//		sinlgeLinkedList.print();

		sinlgeLinkedList.insertSorted(emp1);
		sinlgeLinkedList.print();
		System.out.println("****************");
		sinlgeLinkedList.insertSorted(emp2);
		sinlgeLinkedList.print();
		System.out.println("****************");

		sinlgeLinkedList.insertSorted(emp3);
		sinlgeLinkedList.print();
		System.out.println("****************");

		sinlgeLinkedList.insertSorted(empDuplicate);
		sinlgeLinkedList.print();
	}

	public static void stackArray() {
		StackArray stack = new StackArray(10);
		stack.push(new Employee("A", "A", 1));
		stack.push(new Employee("B", "B", 2));
		stack.push(new Employee("C", "C", 3));
		stack.push(new Employee("D", "D", 4));

//		stack.printStack();
		System.out.println(stack.pop());

		System.out.println(stack.peek());

	}

	public static void linkedStack() {
		LinkedStack stack = new LinkedStack();
		stack.push(new Employee("A", "A", 1));
		stack.push(new Employee("B", "B", 2));
		stack.push(new Employee("C", "C", 3));
		stack.push(new Employee("D", "D", 4));

//		stack.printStack();
		System.out.println(stack.pop());

		System.out.println(stack.peek());

	}

	public static void stackChallenge() {
		StackChallenge stack = new StackChallenge();
		System.out.println(stack.isPalindrome("I did, did I?"));
	}

	private static void arrayQueue() {
		ArrayQueue arrQueue = new ArrayQueue(10);
		arrQueue.add(new Employee("A", "A", 1));
		arrQueue.add(new Employee("B", "B", 2));
		arrQueue.add(new Employee("C", "C", 3));
		arrQueue.add(new Employee("D", "D", 4));

		arrQueue.printQueue();
		System.out.println("***********");

		System.out.println(arrQueue.remove());
		System.out.println("***********");

		arrQueue.printQueue();
		System.out.println("***********");
		System.out.println(arrQueue.peek());

	}

	private static void queueChallenge() {
		QueueChallenge queue = new QueueChallenge();
		System.out.println(queue.checkPalindrome("NKN"));
	}

	private static void hashTable() {
		SimpleHashTable sht = new SimpleHashTable();
		sht.put("A", new Employee("A", "A", 1));
		sht.put("AB", new Employee("B", "B", 2));
		sht.put("ABC", new Employee("C", "C", 3));
		sht.put("D", new Employee("D", "D", 4));
//		sht.printHashTable();
//		System.out.println(sht.get("ABC"));
		sht.checkHashTable();
	}
}
