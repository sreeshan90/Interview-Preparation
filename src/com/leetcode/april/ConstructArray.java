package com.leetcode.april;

/**
 * https://leetcode.com/problems/beautiful-arrangement-ii/
 */
public class ConstructArray {

    public int[] constructArray(int n, int k) {

        // 1, k+1, 2, k, 3 ... so have diff = k,k-1,k-2....1

        int[] res = new int[n];
        int inc = 1, dec = k+1;
        for (int i=0; i<n; i++) {

            if (i%2 == 0) {
                res[i] = inc++;
            }
            else {
                res[i] = dec--;
            }
        }

        for (int i = k+1; i < n; i++)  {
            res[i] = i+1;
        }
        return res;
    }

}
