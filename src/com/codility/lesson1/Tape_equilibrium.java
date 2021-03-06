package com.codility.lesson1;

/*

Question : https://codility.com/demo/take-sample-test/tape_equilibrium/
@author: Sreesha Nagaraj


*/


public class Tape_equilibrium {

	public static int solution(int[] A) {
		if (A == null || A.length == 0)
			return -1;
		int len = A.length;
		long sum = 0;
		for (int i = 0; i < len; i++) {
			sum += A[i];
		}
		long minDiff = -1;
		long leftSum = 0;
		
		for (int i = 1; i < len; i++) {
			
			leftSum += A[i - 1];
			
			long tmpDiff = sum - leftSum * 2;
			
			if (tmpDiff < 0)
				tmpDiff = -tmpDiff;

			if (minDiff == -1 || minDiff > tmpDiff)
				minDiff = tmpDiff;
		}
		return (int) minDiff;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { -10, -20, -30, -40, 100 }));
	}

}
