package com.leetcode;

public class atoi {

	public static int myAtoi(String str) {

		str = str.trim();

		if (null == str || str.isEmpty() || str.length() == 0) {
			return 0;
		}

		if (str.equals("+") || str.equals("-")) {
			return 0;
		}

		str = str.split(" ")[0];
		try {
			if (str.matches("^[+-]?[0-9]*.[0-9]*$")) {
				double resInter = Double.parseDouble(str);

				int res = (int) resInter;

				if (res < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
				if (res > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				return res;
			}

			else {

				return 0;
			}

		}

		catch (java.lang.NumberFormatException e) {
			return 0;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "3.14159";

		System.out.println(myAtoi(str));

		// double res =Double.parseDouble(str);

		// System.out.println((int)res);
		
	}

}
