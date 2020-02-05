package com.leetcode;

public class FirstAndLastOccurance {

    public static void main(String[] args) {
       int[] nums = {5,7,7,8,8,10};
       int target = 6;

       int[] result = new int[2];

       result[0] = binarySearch(nums, target, true);
       result[1] = binarySearch(nums, target, false);
       System.out.println(result[0] + " "+ result[1]);
    }

    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];
        result[0] = binarySearch(nums, target, true);
        result[1] = binarySearch(nums, target, false);

        return result;
    }

    public static int binarySearch( int[] arr, int target, boolean isLeft) {

        int low = 0;
        int high = arr.length-1;

        while (low<=high) {
            int mid = (low+high)/2;
            if(arr[mid] == target) {
                if (isLeft) {
                    if(mid==0 || arr[mid-1] != arr[mid]) {
                        return mid;
                    }
                    else{
                        high = mid-1;
                    }
                }
                else {
                    if(mid==arr.length-1 || arr[mid] != arr[mid+1]) {
                        return mid;
                    }
                    else{
                        low = mid+1;
                    }
                }
            }
            else if(target < arr[mid]) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
    }
}
