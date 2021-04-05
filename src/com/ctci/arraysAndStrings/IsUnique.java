package com.ctci.arraysAndStrings;

// determine if a string has all unique characters
public class IsUnique {
    public static void main(String[] args) {

        isUnique("asbd");
    }

    public static void isUnique(String input) {

        int[] arr = new int[128];

        for(char c : input.toCharArray()) {
            if (arr[c] == 1) {
                System.out.println("Not unique");
                return;
            }
            // mark visited
            arr[c] = 1;
        }
        System.out.println("Is Unique");
    }
}

// Time complexity: O(n) n - length of input array
// space completity: O(1)
