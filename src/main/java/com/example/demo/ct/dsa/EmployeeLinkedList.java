package com.example.demo.ct.dsa;

import lombok.Data;

@Data
public class EmployeeLinkedList {
	private EmployeeNode head;
	private int size;

	public void addToFront(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		node.setNext(head);
		head = node;
		size++;
	}

	public void addToLast(Employee employee) {
		EmployeeNode node = new EmployeeNode(employee);
		EmployeeNode current = head;
		EmployeeNode lastNode = null;
		while (current != null) {
			if (current.getNext() == null) {
				current.setNext(node);
//				break;
			}
			current = current.getNext();
		}
	}

	public EmployeeNode removeFront() {
		if (head == null) {
			return null;
		}
		EmployeeNode removedElement = head;
		head = head.getNext();
		size--;
		return removedElement;

	}

	public void removeByIndex(int id) {
		if (head == null)
			return;

		// If the head node itself holds the key to be deleted
		if (head.getEmployee().getId() == id) {
			head = head.getNext();
			return;
		}
		EmployeeNode prev = null;
		EmployeeNode current = head;
		while (current != null && current.getEmployee().getId() != id) {
			prev = current;
			current = current.getNext();
		}

		// If the key was not found
		if (current == null)
			return;

		// Unlink the node from the linked list
		prev.setNext(current.getNext());
	}

	public void insertSorted(Employee employee) {
		if (head == null) {
			this.addToFront(employee);
		}

		EmployeeNode current = head.getNext();
		EmployeeNode previous = head;
		while (current != null && current.getEmployee().getId() < employee.getId()) {
			previous = current;
			current = current.getNext();
		}
		EmployeeNode newNode = new EmployeeNode(employee);
		newNode.setNext(current);
		previous.setNext(newNode);
		size++;
	}

	public void print() {
		EmployeeNode current = head;
		while (current != null) {
			System.out.println("=>" + current);
			current = current.getNext();
		}
	}
}
