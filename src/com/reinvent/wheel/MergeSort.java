package com.reinvent.wheel;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4,2,52,32,6,2,4,23,1};
        System.out.println(Arrays.toString(sort(arr)));
    }
    public static int[] sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int[] left = sort(Arrays.copyOfRange(arr, 0, arr.length/2));
        int[] right = sort(Arrays.copyOfRange(arr, (arr.length/2), arr.length));
        return merge(left, right);
    }

    public static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i=0, j=0, k=0;

        while (i<a.length && j<b.length) {
            res[k++] = (a[i] < b[j]) ? a[i++] : b[j++];
        }

        while (i<a.length) {
            res[k++] = a[i++];
        }

        while (j<b.length) {
            res[k++] = b[j++];
        }

        return res;
    }
}
