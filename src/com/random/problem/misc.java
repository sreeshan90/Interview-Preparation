package com.random.problem;

import java.util.*;

public class misc {

	public static void main(String args[]) {

		/*String input = "Helo";

		System.out.println(isUnique("Helo asdhk254\njs\n"));

		LinkedHashMap map = new LinkedHashMap(){
			protected boolean n(Map.Entry eldest)
			{
				return this.size() > 10;
			}
		};*/

		Queue<Integer> q = new LinkedList<>();

		q.offer(1);
		q.offer(2);
		q.offer(3);
	}

	public static boolean isUnique(String input) {

		int[] refArr = new int[256];

		for (int i = 0; i < input.length(); i++) {

			if (refArr[(int) input.charAt(i)] == 1) {
				return false;

			}
			refArr[(int) input.charAt(i)] = 1;

		}

		return true;
	}
}
