package com.ctci.arraysAndStrings;

import java.util.Arrays;

public class CheckPermutation {
    public static void main(String[] args) {
        checkPermute("abcd", "abac");
    }

    public static void checkPermute(String a, String b) {
        if (a.length() != b.length()) {
            System.out.println("Not a permutation");
            return;
        }

        char[] arr_A = a.toCharArray();
        char[] arr_B = b.toCharArray();

        Arrays.sort(arr_A);
        Arrays.sort(arr_B);

        for (int i=0; i<arr_A.length; i++) {
            if (arr_A[i] != arr_B[i]) {
                System.out.println("Not a permutation");
                return;
            }
        }
        System.out.println("Is a permutation");

    }
}
