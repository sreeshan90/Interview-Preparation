package com.amazon;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	public List<String> generateParenthesis(int n) {

		List<String> res = new ArrayList<>();

		backTrack(n, res, 0, 0, "");

		return res;
	}

	public void backTrack(int n, List<String> list, int openIndex, int closeIndex, String str) {

		if (str.length() == n * 2) {
			list.add(str);
			return;
		}

		if (openIndex < n) {
			backTrack(n, list, openIndex + 1, closeIndex, str + "(");
		}

		if (closeIndex < openIndex) {
			backTrack(n, list, openIndex, closeIndex + 1, str + ")");
		}

	}
	
	public static void main(String args[]){
		GenerateParanthesis gen = new GenerateParanthesis();
		
		System.out.println(gen.generateParenthesis(3));
	}

}
