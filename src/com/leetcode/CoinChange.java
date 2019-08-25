package com.leetcode;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];

        dp[0] = 0;

        // bottom up approach

        for(int val=1;val<=amount;val++){
            //calculate min coins for each amount until you reach final amount

            dp[val] = Integer.MAX_VALUE/2;

            //loop thru each coin possibility

            for(int coin : coins){

                if(coin <= val){

                    //min of current min or 1 = coins required for remaning amount
                    dp[val] = Math.min(dp[val], 1+dp[val-coin]);
                }
            }
        }

        if(dp[amount] >= Integer.MAX_VALUE/2)
            return -1;

        return dp[amount];


    }
}
