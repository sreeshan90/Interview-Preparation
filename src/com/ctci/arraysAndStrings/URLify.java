package com.ctci.arraysAndStrings;

import java.util.Arrays;

public class URLify {

    public static void main(String[] args) {
        System.out.println(urlify("Mr John Smith         ", 13));
    }

    public static String urlify(String str, int trueLength) {

        // count number of white spaces to calculate where to start from the right to left

        char[] arr = str.toCharArray();
        int spaceCount = 0;
        for(int i=0; i < trueLength; i++) {
            if (arr[i] == ' ') {
                spaceCount++;
            }
        }
        // two more for each space we have + original length of string

        int newIndex = trueLength - 1 + (2*spaceCount);

        for (int j = trueLength - 1; j>=0; j--) {
            if (arr[j] == ' ') {
                arr[newIndex] = '0';
                arr[newIndex-1] = '2';
                arr[newIndex-2] = '%';
                newIndex -= 3;
            }
            else {
                arr[newIndex] = arr[j];
                newIndex--;
            }
        }

        return String.valueOf(arr);
    }

}
