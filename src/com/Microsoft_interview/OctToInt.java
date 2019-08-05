package com.sreesha.test.microsoft;

public class OctToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int atoi8(String input) {

		// convert to a long
		// assumption - input string doesnt exceed Long.MAX_VALUE - return value
		// is int hence, safe to assume
		int num = 0;
		long oct = Long.parseLong(input);
	
		int i = 0;

		while (oct != 0) {

			num = (int) (num + (oct % 10) * Math.pow(8, i));
			i++;
			// extract digits
			oct = oct / 10;

		}
		return num;
	}
}
