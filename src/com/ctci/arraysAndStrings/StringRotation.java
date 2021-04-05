package com.ctci.arraysAndStrings;

public class StringRotation {

    public static void main(String[] args) {
        System.out.println(isSubString("Demographic", "Demographic"));
    }

    public static boolean isSubString(String s1, String s2) {
        int i=0, j=0;
        if (s1.length() != s2.length()) {
            return false;
        }
        while (i<s1.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                i++;

            }else{
                i++;
                j++;
            }

        }
    // reset - if rotation - every character from here must be equal
        i = 0;
        while(j<s2.length()) {
            if (s2.charAt(j++) != s1.charAt(i++)) {
                return false;
            }
        }

        return true;
    }
}
