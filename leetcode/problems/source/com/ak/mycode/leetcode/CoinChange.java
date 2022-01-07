package com.ak.mycode.leetcode;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1,2,5},23));
    }
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int coin : coins) {
            for (int amountIndex = coin; amountIndex <= amount; amountIndex++) {
                dp[amountIndex] = Math.min(dp[amountIndex], dp[amountIndex - coin] + 1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

}

//link - https://leetcode.com/problems/coin-change/

/*
Question : -
    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
    Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
    You may assume that you have an infinite number of each kind of coin.
 */

/*
Example : -
    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1
 */

//level - medium

//algorithms used - dp

//available in lists - amazon-questions

//Time Complexity - O(n*m) - n : coins size, m : amount

//Space Complexity - O(m)
