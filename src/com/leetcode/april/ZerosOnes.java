package com.leetcode.april;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZerosOnes {


    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10","0","1"}, 1, 1));
    }
        public static int findMaxForm(String[] strs, int m, int n) {

            //stores zero count for each string as value. str.length - zero count = one count
            Map<String, Integer> map = new HashMap<>();

            for (String str : strs) {
                map.put(str, countZeros(str));
            }
            int result = 0;
            // check for each possiblity
            for (int i = 0; i< strs.length; i++) {

                List<String> intermediet = new ArrayList<>();
                int runnM = m, runnN = n;

                int zCount = map.get(strs[i]);
                int oCount = strs[i].length() - map.get(strs[i]);

                if(zCount <= m && oCount <= n) {

                    intermediet.add(strs[i]);
                    runnM -= zCount;
                    runnN -= oCount;

                    for (int j = 0; j < strs.length; j++) {
                        if (i == j) continue;
                        // check if you can add this string
                        int zCountInner = map.get(strs[j]);
                        int oCountInner = strs[j].length() - map.get(strs[j]);

                        if (zCountInner <= runnM && oCountInner <= runnN) {
                            intermediet.add(strs[j]);
                            runnM -= zCountInner;
                            runnN -= oCountInner;
                        }

                    }

                    result = Math.max(result, intermediet.size());
                }
            }

            return result;
    }

    public static int countZeros(String str) {
        char[] arr = str.toCharArray();
        int result = 0;

        for(char c : arr) {
            if (c == '0') {
                result++;
            }
        }

        return result;
    }

}
