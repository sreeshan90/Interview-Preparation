package com.leetcode;

// https://leetcode.com/problems/132-pattern/

public class _132Problem {
    public boolean find132pattern(int[] nums) {

        // Intuition - brute force n^3 - reduce one loop by keeping track of the least(min) seen so far for i
        // in 1, 2, 4, 3 -> 1,4,3 and 2,4,3 can form the pattern - hence the lowest i  works

        int min_i = Integer.MAX_VALUE;

        for(int j = 0; j<nums.length; j++) {
            min_i = Math.min(min_i, nums[j]);
            for(int k=j+1; k< nums.length; k++) {
                if(nums[k] < nums[j] && min_i < nums[k]){
                    return true;
                }
            }
        }
        return false;
    }
}
