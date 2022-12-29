package com.leetcode.lc75;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry entry : map.entrySet()) {
            result += (int) entry.getValue() / 2 * 2;
            if (result % 2 == 0 && (int) entry.getValue() % 2 == 1) {
                result += 1;
            }
        }

        return result;
    }
}
