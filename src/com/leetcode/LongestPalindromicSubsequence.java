package com.leetcode;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {

    }

    public int longestPalindromeSubseq(String s) {

        int[][] dp = new int[s.length()][s.length()];

        //init - all
        for(int i=0;i<s.length();i++){

            dp[i][i] = 1;
        }


        for(int k=0;k<s.length();k++){

            for(int i=0;i<s.length();i++){

                int j = i+k+1;

                if(j>s.length()-1){
                    break;
                }

                if(s.charAt(i) == s.charAt(j)){

                    dp[i][j] = 2+dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }

            }
        }

        return dp[0][s.length()-1];

    }
}
