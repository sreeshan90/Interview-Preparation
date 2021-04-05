package com.ctci.arraysAndStrings;

public class PalindromePermutation {

    public static void main(String[] args) {
        System.out.println(solution("coca"));
    }

    public static boolean solution(String str) {
        int[] arr = new int[256];

        for (char c : str.toCharArray()) {
            if ( c != ' ') {
                arr[c] += 1;
            }
        }

        int oneCount = 0;

        for (int charCount : arr) {
            if (charCount % 2 == 1) {
                oneCount++;
            }
            // if more than one then return false;
            if (oneCount > 1) {
                return false;
            }
        }

        return true;
    }

}
