package com.leetcode;

public class DutchNationalFlag {

    // https://leetcode.com/problems/sort-colors/

    public void sortColors(int[] nums) {

        int i= 0, index = 0;
        int j = nums.length-1;

        while(index<=j) {

            if(nums[index] == 0) {
                nums = swap(nums, index, i);
                index++;
                i++;
            }
            else if (nums[index] == 2) {
                nums = swap(nums, index, j);
                j--;
            }
            else{
                index++;
            }
        }
    }

    public int[] swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }
}
