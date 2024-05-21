package com.example.demo.ct.dsa;

import lombok.Data;

@Data
public class EmployeeNode {
	private Employee employee;
	private EmployeeNode next;
	// This will be Doubly Linked List
	private EmployeeNode previous;

	public EmployeeNode(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return employee.toString();
	}

}
