package com.ak.mycode.leetcode;

public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(new FibonacciNumber().fib(10));
    }

    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i<=n; i++) {
            fib(i,dp);
        }
        return dp[n];
    }

    public void fib(int n, int[] dp) {
        dp[n] = dp[n-1] + dp[n-2];
    }
}
