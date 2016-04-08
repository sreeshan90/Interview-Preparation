package com.google.interview;

public class CTCT_1_3 {

	public static void main(String args[]) {

		String a = "abcsad";
		String b = "cabasd";

		System.out.println(isPermutation(a, b));

	}

	public static boolean isPermutation(String a, String b) {

		int[] letters = new int[256];

		 if(a.length()!=b.length()){
			 return false;
		 }
		// count the no of occurances of each char in the string

		for (int i = 0; i < a.length(); i++) {
			letters[(int) a.charAt(i)]++;

		}

		for (int i = 0; i < b.length(); i++) {

			if (--letters[(int) b.charAt(i)] < 0) {
				return false;
			}

		

		}
		
		return true;

	}

}
