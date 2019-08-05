package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] merge(int[][] arr) {
		if (arr == null || arr.length <= 1)
			return arr;
		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int left = arr[i][0], right = arr[i][1];
			while (i + 1 < arr.length && right >= arr[i + 1][0])
				right = Math.max(right, arr[++i][1]);
			list.add(new int[] { left, right });
		}
		return list.toArray(new int[list.size()][]);
	}

}
