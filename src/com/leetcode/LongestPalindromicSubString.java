package com.leetcode;

public class LongestPalindromicSubString {

    public static void main(String[] args) {
        String test = "aaabaaaa";


        System.out.println(test.lastIndexOf('a'));
    }

    public String longestPalindrome(String s) {

        if (s.length() == 0) {
            return s;
        }

        if (s.length() == 1) {
            return s;
        }

        int res = 0;
        char[] arr = s.toCharArray();
        String palin = "" + arr[0] + "";
        //String palin = "";

        for (int i = 0; i < arr.length; i++) {

            for (int j = s.lastIndexOf("" + arr[i] + ""); j >= 0; j--) {

                if (isPalindrome(arr, i, j)) {

                    if (j - i > res) {
                        palin = s.substring(i, j + 1);
                        res = j - i;
                    }

                }
            }


        }

        return palin;
    }

    public boolean isPalindrome(char[] arr, int i, int j) {
        if (arr.length == 0 || arr.length == 1) {
            return true;
        }

        while (i < j) {

            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public String longestPalindromeDP(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            //length is odd or even
            int[] n1 = check(s, i, i);
            int[] n2 = check(s, i, i + 1);
            //find out the longest Palindromic between n1 and n2;
            int[] max = (n1[1] - n1[0] + 1) > ((n2[1] - n2[0] + 1)) ? n1 : n2;
            //if max greater than longest;
            if (max[1] - max[0] > right - left) {
                left = max[0];
                right = max[1];
            }
        }
        return s.substring(left, right + 1);
    }

    private int[] check(String s, int left, int right) {
        //中间开花
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //before loop close;
        //left minue 1, right add 1, then find out loop cannot continue;
        //left + 1 and right - 1 to set the pointer at true position;
        //we are calcualting the length, not index
        // add + 1 after the index calcuation
        return new int[]{left + 1, right - 1};
    }

    public String longestPalindrome3DP(String s) {

        if (s.length() == 0) {
            return s;
        }

        if (s.length() == 1) {
            return s;
        }
        int n = s.length();

        int left = 0;
        int right = 0;

        boolean dp[][] = new boolean[n][n];

        for (int j = 1; j < n; j++) {

            for (int i = 0; i < j; i++) {

                boolean isInner = dp[i + 1][j - 1] || ((j - i) <= 2);

                if (isInner && s.charAt(i) == s.charAt(j)) {

                    dp[i][j] = true;

                    if ((j - i) > (right - left)) {
                        left = i;
                        right = j;
                    }
                }


            }

        }


        return s.substring(left, right + 1);

    }
}
