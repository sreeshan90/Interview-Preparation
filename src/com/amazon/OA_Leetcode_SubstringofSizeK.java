package com.amazon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class OA_Leetcode_SubstringofSizeK {

    public static void main(String[] args) {

        System.out.println(subStringofSizeK("awaglknagawunagwkwagl",4));
    }
    public static List<String> subStringofSizeK(String str, int K){

        Set<String> set = new HashSet<>();

        for(int i = 0; i< str.length();i++){

            StringBuilder sb = new StringBuilder();

            int[] cArr = new int[26];

            for(int j = i; j<i+K && j< str.length(); j++){

                if(cArr[str.charAt(j)-'a'] != 1){
                    sb.append(str.charAt(j));
                    cArr[str.charAt(j)-'a'] = 1;
                }else{
                    break;
                }

            }

            if(sb.length() == K){
                set.add(sb.toString());
            }
        }

        return new LinkedList<>(set);
    }
}
