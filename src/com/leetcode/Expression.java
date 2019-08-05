package com.sreesha.test;

import java.util.Stack;

class Expression {

	public String decodeString(String s) {

		StringBuilder sb = new StringBuilder();

		if (s.isEmpty()) {
			return "";
		}

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ']') {
				st.push(s.charAt(i));
			} else {
				char top = st.peek();
				if (top != '[') {
					StringBuilder sbTemp = new StringBuilder();
					while (top != '[') {
						top = st.pop();
						if (top != '[')
							sbTemp.append(top);
					}
					sbTemp.reverse();
					int multipleFactor = Integer.parseInt(st.pop() + "");

					for (int j = 0; j < multipleFactor; j++) {
						sb.append(sbTemp);
					}
				} else {
					st.pop();
					int multipleFactor = Integer.parseInt(st.pop() + "");
					StringBuilder sbTemp = new StringBuilder(sb.toString());

					for (int j = 1; j < multipleFactor; j++) {

						sb.append(sbTemp);
					}
				}

			}
		}

		return sb.toString();
	}
}
