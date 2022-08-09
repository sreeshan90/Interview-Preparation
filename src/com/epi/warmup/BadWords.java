package com.epi.warmup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BadWords {
    public static void main(String[] args) {
        String statement = " hello jerk jerk!";
        String[] badWords =  {"jerk", "lame", "loude"};

        System.out.println(replaceBadWords(statement, badWords));
    }

    private static String replaceBadWords(String statement, String[] badWords) {
       /* String[] words = statement.split(" ");
        Set badWordsSet = new HashSet(Arrays.asList(badWords));
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            if (badWordsSet.contains(word)) {
                char[] chars = word.toCharArray();
                for (char c : chars) {
                    res.append('*');
                }
            }
            else {
                res.append(word);
            }
            res.append(' ');
        }

        return res.toString().trim();*/

        for (String word : badWords) {
            System.out.println(statement.indexOf(word));
        }

        return " ";
     }
}
