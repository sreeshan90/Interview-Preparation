package com.google.interview;

public class CTCT_1_4 {

	public static void main(String args[]) {

		String a = "Mr John Smith    ";
		int trueLength = 13;

		char[] cArr = a.toCharArray();
		int finalLength = cArr.length;

		for (int i = trueLength-1; i >= 0; i--) {

			if (cArr[i] == ' ') {
				// move by two places
				
				cArr[finalLength-1] = '0';
				cArr[finalLength-2] = '2';
				cArr[finalLength-3] = '%';
				finalLength -= 3;
			} else {
				cArr[finalLength-1] = cArr[i] ;
				finalLength -= 1;
				
			}

		}

		for (int i = 0; i < cArr.length; i++)

		{
			System.out.print(cArr[i]);
		}

	}

}
