package com.geeksForGeeks.random;

public class convertBinaryNumToOne {

    public static void main(String[] args) {
        System.out.println(calculate("101110"));
    }

    public static int calculate(String str) {

        StringBuilder sb = new StringBuilder(str);

        if(str == null || str.length() == 0) {
            return 0;
        }
        int count = 0;
        while(sb.length()!=1) {
            String curr = sb.toString();
            if(curr.charAt(curr.length()-1) == '0') {
                sb = new StringBuilder(curr.substring(0, curr.length()-1));
                count++;
            }
            else {
                int num = Integer.parseInt(curr, 2);
                num++;
                sb = new StringBuilder(Integer.toBinaryString(num));
                count++;
            }
        }
        return count;
    }
}
