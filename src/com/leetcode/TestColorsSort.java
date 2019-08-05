package com.leetcode;

import java.util.Arrays;

public class TestColorsSort {

	public static void main(String args[]){
		int nums[] = {2,0,1};
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
	
    public static void sortColors(int[] nums) {
       
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0) zeros++;
            if(nums[i] == 1) ones++;
            if(nums[i] == 2) twos++;
        }
        
        for(int j=0;j<=zeros-1;j++){
            nums[j] = 0;
        }
        for(int j=zeros;j<=zeros+ones-1;j++){
            nums[j] = 1;
        }
        for(int j=zeros+ones;j<=zeros+ones+twos-1;j++){
            nums[j] = 2;
        }
       
    }
}
