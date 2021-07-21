package com.microsoft.interview;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.*;

class Divisible {

    static Map <Integer, Integer> map = new HashMap<>();

    public static void main(String [] args) {

        System.out.println(getMinSteps(10));
    }

   public static int getMinSteps(int n) {

        if (map.containsKey(n)) {
            return map.get(n);
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        if (n == 1 || n == 0) {
            return 0;
        }

        if (n%3 == 0) {
            b = getMinSteps(n/3) + 1;
        }

        if (n%2== 0) {
            a = getMinSteps(n/2) + 1;
        }

        int c = getMinSteps(n-1) + 1;
        int min = Math.min(c, Math.min(a,b));
        map.put(n, min);
        return min;
    }

}
