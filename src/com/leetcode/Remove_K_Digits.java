package com.sreesha.test;

public class Remove_K_Digits {

	// public static String num = "1432219";

	public static void main(String[] args) {

		// LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		String num = "0";
		int k = 0;

		while (true) {

			if (k == num.length()) {
	
				break;
			}
			num = removeOne(num);
			k--;
			if (k == 0)
				break;
		}
		System.out.println(num);
	}

	public static String removeOne(String num) {

		StringBuilder sb = new StringBuilder(num);
		char[] arr = num.toCharArray();
		boolean removed = false;
		try {
			for (int i = 0; i < num.length(); i++) {
				// find the digit whose next value is less than that

				if (i + 1 != num.length()) {
					if (arr[i] > arr[i + 1]) {
						sb = sb.deleteCharAt(i);

						removed = true;
						break;
					}
				}

			}

			if (!removed) {
	
				sb = sb.deleteCharAt(num.length() - 1);
			}
			// remove leading zeros

			while (sb.charAt(0) == '0' && sb.length()>1) {

				sb = sb.deleteCharAt(0);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return sb.toString();
	}

}
