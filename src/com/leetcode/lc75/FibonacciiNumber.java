package com.leetcode.lc75;

public class FibonacciiNumber {
    // https://leetcode.com/problems/fibonacci-number
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        return fib (n - 1) + fib (n - 2);
    }
}
