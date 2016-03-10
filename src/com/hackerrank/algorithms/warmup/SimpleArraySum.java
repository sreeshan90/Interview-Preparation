package com.hackerrank.algorithms.warmup;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/simple-array-sum
 * @author Sreesha Nagaraj
 */

public class SimpleArraySum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
    }
}
