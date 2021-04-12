package com.leetcode.april;

public class MinOperations {
    public static void main(String[] args) {
        System.out.println(minOperations(3));
    }
    public static int minOperations(int n) {

        int[] arr = new int[n];
        int result = 0;
        int mid = 0;
        for (int i = 0; i<n; i++) {
            arr[i] = (2*i) + 1;
        }

        if (n%2 == 0) {
            // find the mid value
            mid = (arr[n/2] + arr[n/2 - 1]) / 2;
        }
        else {
            mid = arr[n/2];
        }

        int j = n-1;
        while (j>=n/2) {
            result += arr[j] - mid;
            j--;
        }

        return result;
    }
}
