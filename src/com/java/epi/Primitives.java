package com.java.epi;

public class Primitives {

    public static void main(String[] args) {

       // System.out.println(countNumberofBitsSetToOne(2));
        System.out.println(reverseInteger(-3325));
    }

    public static int countNumberofBitsSetToOne( int n) {

        int count =0;
        while(n!=0) {
            count+= (n & 1);
            n = n >>> 1;
        }

        return count;
    }

    public static int reverseInteger(int n) {
        boolean flag = false;

        if(n<0) {
            flag = true;
            n = n*-1;
        }
        int result = 0;

        while(n!=0) {
            result = result*10 + n%10;
            n=n/10;
        }
        result = flag?result*-1:result;

        return result;
    }
}
