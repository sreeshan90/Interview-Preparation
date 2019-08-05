package com.sreesha.test.microsoft;

public class ReverseWords {
	public static String reverseWords(String input) {

		char[] arr = input.toCharArray();

		int st = 0;
		int end = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == ' ') {
				// encountyered space - reverse the subarray

				end = i - 1;

				// swap
				arr = swap(st, end, arr);

				// update the pointers
				st = i + 1;
				end = i + 1;
			}

		}
		
		//last word reverse
		
		input = new String(arr);
		
		arr = input.toCharArray();
		for (int i = arr.length-1;i>0 ; i--) {
			if (arr[i] == ' ') {
				st=i+1;
				end=arr.length-1;
				
				arr = swap(st, end, arr);
				break;
			}
		}

		return new String(arr);

	}

	public static char[] swap(int st, int end, char[] arr) {

		while (st < end) {

			// swap arr[st] and arr[end]

			char temp = arr[st];
			arr[st] = arr[end];
			arr[end] = temp;

			st = st + 1;
			end = end - 1;

		}
		return arr;
	}
}
