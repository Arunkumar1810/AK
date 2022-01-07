package com.ak.mycode.leetcode;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(45));
    }

    int[] dp = new int[46];
    public int climbStairs(int n) {
        if(dp[n]>0) return dp[n];
        if(n<=2) return n;
        dp[n]=climbStairs(n-1)+climbStairs(n-2);
        return dp[n];
    }
}

//link - https://leetcode.com/problems/climbing-stairs/

/*
Question : -
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

/*
Example : -
    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps
 */

//level - easy

//algorithms used - dp

//available in lists - amazon-questions

//Time Complexity - O(n)

//Space Complexity - O(n)