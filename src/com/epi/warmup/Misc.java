package com.epi.warmup;
import java.util.Arrays;

public class Misc {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 3,2,4,1,4,5,2,1,4,5,6};
        Arrays.sort(arr);

        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
