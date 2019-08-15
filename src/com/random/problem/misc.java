package com.random.problem;

public class misc {

	public static void main(String args[]) {

		String input = "Helo";

		System.out.println(isUnique("Helo asdhk254\njs\n"));

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
