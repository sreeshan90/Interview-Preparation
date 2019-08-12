package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _3Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,-2,-4,9,4,3};
		System.out.println(threeSum(nums));
		
	}

	public static Set<List<Integer>> threeSum(int[] nums) {

		Set<List<Integer>> res = new HashSet<>();

		Arrays.sort(nums);
		int zeroIndex = Arrays.binarySearch(nums, 0);
		if (zeroIndex != -1) {
			// contains a 0
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < zeroIndex; i++) {
				int positiveIndex = Arrays.binarySearch(nums, nums[i] * -1);
				if (positiveIndex >= 0) {
					list.add(0);
					list.add(nums[i]);
					list.add(nums[positiveIndex]);
					
					res.add(list);

				}
			}
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] > 0) {
					zeroIndex = i;
					break;
				}
			}
		}

		for (int i = 0; i < zeroIndex; i++) {

			for (int j = 0; j < zeroIndex; j++) {
				int posIndex = Arrays.binarySearch(nums, (-1 * (nums[i] + nums[j])));

				if (posIndex != -1) {

					List<Integer> list = new ArrayList<>();

					list.add(posIndex);
					list.add(i);
					list.add(j);

					res.add(list);
				}

			}
		}

		return res;

	}

}
