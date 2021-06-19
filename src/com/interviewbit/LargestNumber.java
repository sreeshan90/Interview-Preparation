package com.interviewbit;
import java.util.Arrays;

public class LargestNumber {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY

    public static void main(String[] args) {

        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
    public static String largestNumber(final int[] A) {

        String[] arr = new String[A.length];

        for (int i=0; i<A.length; i++) {
            arr[i] = String.valueOf(A[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            String s1 = a + b;
            String s2 = b + a;
            return s1.compareTo(s2);
        });

        if(arr[0].charAt(0) == '0')
            return "0";

        System.out.println(Arrays.toString(arr));

        StringBuilder sb = new StringBuilder();
        for(String s: arr)
            sb.append(s);

        return sb.toString();

    }
}
