package com.example.demo.ct.dsa;

import lombok.Data;

@Data
public class DoublyLinkedList {
	private EmployeeNode head;
	private int size;
	private EmployeeNode tail;

	public void addToFront(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		node.setNext(head);
		if (head == null) {
			tail = node;
		} else {
			head.setPrevious(node);
			node.setNext(head);
		}
		head = node;
		size++;
	}

	public void addToTail(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		if (tail == null) {
			head = node;
		} else {
			tail.setNext(node);
			node.setPrevious(tail);
		}
		tail = node;
		size++;
	}

	public EmployeeNode removeFront() {
		EmployeeNode removedElement = head;
		if (head.getNext() == null) {
			tail = null;
		} else {
			head.getNext().setPrevious(null);
		}
		head = head.getNext();
		size--;
		removedElement.setNext(null);
		return removedElement;

	}

	public EmployeeNode removeEnd() {
		EmployeeNode removedElement = tail;
		if (tail.getPrevious() == null) {
			head = null;
		} else {
			tail.getPrevious().setNext(null);
			tail = tail.getPrevious();
		}
		size--;
		removedElement.setPrevious(null);
		return removedElement;

	}

	public void print() {
		EmployeeNode current = head;
		while (current != null) {
			System.out.println("<=>" + current);
			current = current.getNext();
		}
	}

	public boolean addBefore(Employee employee) {

		if(head == null) return false;
		EmployeeNode current = head;
		while (current != null && current.getEmployee().getId() == employee.getId()) {
			current = current.getNext();
		}
		EmployeeNode newNode = new EmployeeNode(employee);
		if (current == null) {
			return false;
		}

		newNode.setPrevious(current.getPrevious());
		newNode.setNext(current);
		current.setPrevious(newNode);
		if (current == head) {
			head = newNode;
		} else {
			newNode.getPrevious().setNext(newNode);
		}
		size++;
		return true;

	}

}
