package com.leetcode.april;

public class CombinationSum4 {
    public static int combinationSum4(int[] N, int T) {
        int[] dp = new int[T+1];
        dp[0] = 1;
        for (int i = 1; i <= T; i++) {
            for (int num : N) {
                if (num <= i) {
                    dp[i] += dp[i-num];
                }

            }
        }
        return dp[T];
    }


    public static void main(String[] args) {

        System.out.println(combinationSum4(new int[]{1,2,3}, 4));
    }
}
