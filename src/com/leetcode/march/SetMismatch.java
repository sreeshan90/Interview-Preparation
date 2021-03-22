package com.leetcode.march;

import java.util.Arrays;

public class SetMismatch {

    public static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        int res[] = new int[2];

        for(int i=1; i<nums.length; i++) {
            if (prev == nums[i]) {
                res[0] = prev;
            }
            prev = nums[i];
        }

        for(int i=1; i<=nums.length; i++) {
            if (Arrays.binarySearch(nums,i) == -1) {
                res[1] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 3, 4, 5, 5})));
    }
}
