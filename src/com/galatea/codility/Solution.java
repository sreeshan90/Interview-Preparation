package com.galatea.codility;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        int[] num = new int[]{1,2,3};
        System.out.println(solution(num));
        num = new int[]{1,1,6} ;
        System.out.println(solution(num));
        num = new int[]{1, 6, 2, 3};
        System.out.println(solution(num));
        num = new int[]{};
        System.out.println(solution(num));
        System.out.println(solution(null));


    }
    public static int solution(int[] A) {

        if (A != null) {
            int minCount = Integer.MAX_VALUE;

            for (int i = 1; i < 7; i++) {
                int currentCount = 0;
                for(int j=0; j< A.length; j++) {

                    if (i == j) {
                        continue;
                    }
                    else if (i+j == 7) {
                        currentCount = currentCount + 2;
                    }
                    currentCount++;
                }
                minCount = Math.min(minCount, currentCount);
            }

            return minCount;
        }

        return -1;
    }
}
