package com.leetcode.lc75;

public class BestTimeToBuyAndSellStock {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE / 2;

        for (int i : prices) {
            min = Math.min(i, min);
            maxProfit = Math.max(maxProfit , i - min);
        }

        return maxProfit;
    }
}
