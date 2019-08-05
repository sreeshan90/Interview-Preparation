package com.leetcode;
import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {

	public static boolean isValid(String s) {
		 
		HashMap<Character, Character> mappings = new HashMap<Character, Character>();
		 
		 
		mappings.put(')', '(');
		mappings.put('}', '{');
		mappings.put(']', '[');

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (mappings.containsKey(c)) {
				char top = st.isEmpty() ? '@' : st.pop();

				if (top != mappings.get(c)) {
					return false;
				} 
			}
			else {
				st.push(c);
			}

		}
		

		return st.isEmpty();
	}
	
	public static void main(String args[]){
		System.out.println(isValid("()()"));
	}

}
