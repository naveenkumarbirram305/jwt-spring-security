package com.example.demo.ct.dsa;

import java.util.LinkedList;

public class StackChallenge {
	public LinkedList<Character> stack = new LinkedList<Character>();

	public boolean isPalindrome(String str) {
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!Character.isLetterOrDigit(c)) {
				// Skip punctuation marks
				continue;
			}
			stack.push(c);
			temp+=c;
		}
		if (concatenateToString().toLowerCase().equals(temp.toLowerCase())) {
			return true;
		}
		return false;

	}

	public String concatenateToString() {
		StringBuilder sb = new StringBuilder();
		while (stack.size() > 0) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
}
