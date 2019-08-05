package com.leetcode;

import java.util.Scanner;



public class ArmStrong {
	/* package whatever //do not write package name here */

	public static void main(String[] args) {

		int t = 0;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of testcases");
		t = s.nextInt();
		for (int i = 0; i < t; i++) {

			System.out.println("Enter the number to test");
			int num = s.nextInt();
			System.out.println(isArmStrong(num));
		}
		s.close();
	}

	public static String isArmStrong(int num) {

		int armNum = new Integer(num);
	
		int sum = 0;

		while (armNum != 0) {

			int dig = armNum % 10;
			armNum = armNum / 10;
			sum += dig * dig * dig;
		}

		
		if (num == sum) {
		
			return "Yes";
		} else {
			return "No";
		}
	}
}
