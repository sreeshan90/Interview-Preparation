package com.microsoft.interview;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(decodeString("2[abc2[q]]"));

	}

	public static String decodeString(String s) {

		StringBuilder sb =null;

		if (s.isEmpty()) {
			return "";
		}

		Stack<String> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) != ']') {
				st.push(s.charAt(i) + "");

			}

			else {
				String top = st.peek();

				if (!top.equals("[")) {

					StringBuilder sbTemp = new StringBuilder();
					sb = new StringBuilder();
					while (!top.equals("[")) {
						top = st.pop();
						if (!top.equals("["))
							sbTemp.append(top);
					}
				//	sbTemp.reverse();
					
					StringBuilder num = new StringBuilder();
					while(!st.isEmpty() && Character.isDigit(st.peek().toCharArray()[0])){
						num.append(st.pop());	
						}
					
					int multipleFactor = Integer.parseInt(num.reverse().toString());
				
					for (int j = 0; j < multipleFactor; j++) {
						sb.append(sbTemp);

					}
					st.push(sb.toString());
				
				}

			}
		}
		
		StringBuilder result = new StringBuilder();
		while (!st.isEmpty()) {
			String temp = "";
			temp = st.pop();
			result.append(temp);

		}
		return result.reverse().toString();
		
		

			//return sb.reverse().toString();
	//-----------------------------------------	
	/*	Stack<String> contentString = new Stack<>();
		String top = "";

		for (int i = 0; i < s.length(); i++) {
			String temp = "";
			if (s.charAt(i) != ']') {
				contentString.push(s.charAt(i) + "");
			} else {
				while (!contentString.peek().equals("[")) {
					top = contentString.pop();
					temp = top + temp;
				}

				contentString.pop();
			
				String fact = "";
				while (!contentString.isEmpty() && Character.isDigit(contentString.peek().charAt(0))) {
					fact = contentString.pop() + fact;
				}
				int count = Integer.parseInt(fact);
				String interResult = "";
				for (int j = 0; j < count; j++) {
					interResult += temp;
				}
				contentString.push(interResult);
			}
		}
		String result = "";
		while (!contentString.isEmpty()) {
			String temp = "";
			temp = contentString.pop();
			result = temp + result;

		}
		return result;*/
	}

	

}
