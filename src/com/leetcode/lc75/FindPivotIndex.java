package com.leetcode.lc75;

public class FindPivotIndex {

    // Problem: https://leetcode.com/problems/find-pivot-index

    public static int findPivotIndex(int[] nums) {

        int sum = 0;
        for(int x : nums) sum += x;
        int leftSum = 0;
        for (int i=0; i<nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findPivotIndex(new int[] {1,7,3,6,5,6}));
    }
}
