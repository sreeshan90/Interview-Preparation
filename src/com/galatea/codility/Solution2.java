package com.galatea.codility;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(solution("A2Le", "wwqed"));
        System.out.println(solution("A2Le", "2pL1svdfv"));
    }
    public static boolean solution(String s, String t) {
        final String dS = decompress(s);
        final String dT = decompress(t);
        if (dS.length() != dT.length()) {
            return false;
        }
        for (int i = 0; i < dS.length(); i++) {
            if (dS.charAt(i) != dT.charAt(i) && dS.charAt(i) != '.' && dT.charAt(i) !=  '.') {
                return false;
            }
        }
        return true;
    }

    public static String decompress(String str) {

        final StringBuilder decompressed = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                decompressed.append(str.charAt(i));
            }
            for (int j = 0; j < Character.getNumericValue(str.charAt(i)); j++) {
                decompressed.append('.');
            }
        }
        return decompressed.toString();
    }
}
