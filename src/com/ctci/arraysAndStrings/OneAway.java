package com.ctci.arraysAndStrings;

public class OneAway {
    public static void main(String[] args) {
        System.out.println(oneAway("summer", "Gummee"));
    }

    public static boolean oneAway(String s, String t) {

        int sn = s.length();
        int tn = t.length();

        if (sn > tn) {
            return oneAway(t, s);
        }

        for (int i=0; i < sn; i++) {
            if (s.charAt(i) != t.charAt(i)) { //found diff - check if one edit away
                // if string lengths are equal, the rest of the substring must be equal
                if (sn == tn) {
                    return s.substring(i+1).equals(t.substring(i+1));
                }
                // tn is greater in length
                return s.substring(i).equals(t.substring(i+1));
            }
        }

        return (sn+1 == tn);
    }

}
