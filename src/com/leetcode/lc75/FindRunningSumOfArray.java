package com.leetcode.lc75;

import java.util.Arrays;

public class FindRunningSumOfArray {

    // https://leetcode.com/problems/running-sum-of-1d-array/

    public static int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            sum[i] = currSum;
        }

        return sum;
    }

    public static void main(String[] args) {
      Arrays.stream(runningSum(new int[]{1, 2, 3, 4, 5})).forEach(value -> System.out.println(value));
    }
}
