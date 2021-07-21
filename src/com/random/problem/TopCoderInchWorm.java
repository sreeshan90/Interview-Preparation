package com.random.problem;

public class TopCoderInchWorm {

	public static void main(String[] args) {
		System.out.println(lunchtime(11, 2, 4));
		System.out.println(lunchtime(12, 6, 4));
		System.out.println(lunchtime(20, 3, 7));
		System.out.println(lunchtime(21, 7, 3));
		System.out.println(lunchtime(15, 16, 5));
		System.out.println(lunchtime(1000, 3, 7));
		System.out.println(lunchtime(1000, 7, 3));
	}

	public static int lunchtime(int branch, int rest, int leaf) {
		int count = 0;

		for (int i = 0; i <= branch; i = i + rest) {
			if (i % leaf == 0)
				count++;
		}

		return count;
	}

}
