package com.leetcode;

import java.util.Arrays;

public class ReorderLogFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println('Z' - 0);
	}

	public String[] reorderLogFiles(String[] logs) {

		Arrays.sort(logs, (str1, str2) -> {

			String[] split1 = str1.split(" ", 2);
			String[] split2 = str2.split(" ", 2);

			boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
			boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

			if (!isDigit1 && !isDigit2) {
				int comp = split1[1].compareTo(split2[1]);

				if (comp != 0)
					return comp;

				return split1[0].compareTo(split2[0]);
			}

			return isDigit1 ? (isDigit2 ? 0 : 1) : -1;

		});

		return logs;
	}

}
