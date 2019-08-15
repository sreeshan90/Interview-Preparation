package com.leetcode;

public class SearchInRotatedSortedArray {

	//https://leetcode.com/problems/search-in-rotated-sorted-array/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public int search(int[] nums, int target) {
	        
		    
	        if(nums.length == 0){
	            return -1;
	        }
	        int pivot = findPivot(nums);
	        if(nums[pivot] == target){
	            return pivot;
	        }
	        if(pivot == 0){
	            return binarySearch(0, nums.length-1, nums, target);
	        }else if(nums[0]>target){
	             return binarySearch(pivot, nums.length-1, nums, target);
	        }else{
	             return binarySearch(0, pivot, nums, target);
	        }
	        
	    }
	    
	    public int findPivot(int[] nums){
	        
	        int pivot = 0;
	        
	        for(int i=1;i<nums.length;i++){
	            if(nums[pivot]>nums[i]){
	                pivot=i;
	            }
	        }

	        return pivot;
	        
	    }
	    
	    public int binarySearch(int low, int high, int[] nums, int target){
	        
	        while(low<=high){
	            int mid = ((low+high)/2);
	            
	            
	            if(nums[mid] == target){
	                return mid;
	            }
	            
	            if(target<nums[mid]){
	                high = mid-1;
	            }else{
	                low = mid+1;
	            }
	            
	        }
	        
	        return -1;
	    }
	    

}
