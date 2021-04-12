package com.random.problem;

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
