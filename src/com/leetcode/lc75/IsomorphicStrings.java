package com.leetcode.lc75;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    // https://leetcode.com/problems/isomorphic-strings/
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) == t.charAt(i)) {
                    continue;
                }
                else {
                    return false;
                }
            }
            else {
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }
}
