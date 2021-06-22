package com.random.problem;

import java.util.Arrays;

public class StringExercise {
    public static void main(String[] args) {
        int[] arr = new int[26];

        String str = "aab";

        for (char c : str.toCharArray()) {
            arr[c - 'a'] = 1;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("sdf".compareTo("zazaa"));

        System.out.println("abcd".substring(1,2));
    }
}
