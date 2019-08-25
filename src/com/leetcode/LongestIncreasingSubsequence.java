package com.leetcode;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        int[] arr = new int[nums.length];

        //memoize
        for(int i=0;i<nums.length;i++){
            arr[i] = 1;
        }

        if(nums.length == 0){
            return 0;
        }
        int res = 1;

        for(int i = 1; i<nums.length;i++){

            for(int j = 0;j<i;j++){

                if(nums[j]<nums[i]){
                    arr[i] = Math.max(arr[i],arr[j]+1);
                }
                res = Math.max(res,arr[i]);
            }

        }

        return res;
    }
}
