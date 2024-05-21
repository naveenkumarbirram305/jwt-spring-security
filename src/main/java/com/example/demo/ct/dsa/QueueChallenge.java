package com.example.demo.ct.dsa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueChallenge {

	public boolean checkPalindrome(String str) {

		Stack<Character> stack = new Stack<Character>();
		Queue<Character> queue = new LinkedList<>();
		// Push characters onto the stack
		for (char c : str.toCharArray()) {
			stack.push(c);
			queue.add(c);
		}
		String stackString = "";
		for (int i = 0; i <= stack.size(); i++) {
			char top = stack.pop();
			stackString += top;
		}
		String queueString = "";
		for (int i = 0; i <= queue.size(); i++) {
			char top = queue.remove();
			queueString += top;
		}
		return stackString.equals(queueString);
	}
}
