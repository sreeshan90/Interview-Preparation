package com.topcoder.srm;

/**
 *	Rookie SRM 4
 * You have a large collection of marbles, given in String[] marbles,
 * where each character of each element represents the color of a particular marble in your collection.
 * You are planning to select count marbles from your collection.
 * Return the minimum number of different colors that will be present in your selection.
 *
 * Constraints
 * -	marbles will contain between 1 and 50 elements, inclusive.
 * -	Each element of marbles will contain between 1 and 50 characters, inclusive.
 * -	Each character of each element of marbles will be between 'A' and 'Z', inclusive.
 * -	count will be between 0 and the total number of marbles represented in marbles.
 *
 */
public class MarblePicking {

    public int fewestColors(String[] marbles, int count) {

        int[] countArr = new int[26];
        int result = 0;

        for (String str : marbles) {
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                countArr[arr[i] - 'A']++;
            }
        }

        while (count > 0) {
            int maxIndex = getMax(countArr);
            int prevMaxCount = countArr[maxIndex];
            countArr[maxIndex] -= count;
            count -= prevMaxCount;
            result++;
        }

        return result;
    }

    private int getMax(int[] arr) {
        int max = 0;

        for (int i=0; i< arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }

        return max;
    }

}
