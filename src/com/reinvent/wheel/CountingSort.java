package com.reinvent.wheel;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(CountingSort.sort(new int[]{1,4,1,5,6,3,1,3})));

    }

    public static int[] sort(int[] arr) {

        int[] res = new int[arr.length];
        int max = Arrays.stream(arr).max().getAsInt();
        int[] aux = new int[max+1];

        for (int num : arr) {
            aux[num]++;
        }

        int k=0;
        for (int i=0; i<=max; i++) {
            int temp = aux[i];
            while(temp != 0) {
                res[k++] = i;
                temp--;
            }
        }

        return res;
    }
}
