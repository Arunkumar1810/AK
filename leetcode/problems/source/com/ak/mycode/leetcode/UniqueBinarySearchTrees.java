package com.ak.mycode.leetcode;

public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees().numTrees(5));
    }

    int[] dp;
    public int numTrees(int n) {
        if(n<=2) return n;
        dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        return numTrees1(n);
    }

    public int numTrees1(int n) {
        for(int i=3;i<=n;i++) {
            int count = 0;
            for(int left=0;left<i;left++) {
                count+=(dp[left] * dp[i-left-1]);
            }
            dp[i]=count;
        }
        return dp[n];
    }
}

//link - https://leetcode.com/problems/unique-binary-search-trees/

/*
Question : -
    Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

Constraint : -
    1 <= n <= 19
 */

/*
Example : -
    Input: n = 3
    Output: 5
 */

//level - medium

//algorithms used - dp-memoization

//available in lists - tree-tag

//Time Complexity - O(n^2)

//Space Complexity - O(n)