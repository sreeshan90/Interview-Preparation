package com.ctci.arraysAndStrings;

import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {

        System.out.println(compressInPlace("aabcccccaaa"));
    }

    public static String compress(String str) {

        char[] arr = str.toCharArray();
        int i=-1, j=0;
        StringBuilder result = new StringBuilder();

        while(j<str.length()-1) {
            if(arr[j] != arr[j+1]) {
                result.append(arr[j]);
                result.append(j-i);
                i = j;
            }
            j++;
        }
        result.append(arr[j]);
        result.append(j-i);

        return (result.toString().length() < str.length()) ? result.toString() : str;
    }

    public static String compressInPlace(String str) {

        char[] arr = str.toCharArray();
        int i=-1, j=0,k=0;

        while(j<str.length()-1) {
            if(arr[j] != arr[j+1]) {
                arr[k++]=arr[j];
                arr[k++]= (char) ((char) j-i);
                i = j;
            }
            j++;
        }
        arr[k++]=arr[j];
        arr[k++]= (char) ((char) j-i);

        return Arrays.toString(arr);
    }

}
