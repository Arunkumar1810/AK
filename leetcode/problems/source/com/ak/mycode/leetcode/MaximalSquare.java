package com.ak.mycode.leetcode;

public class MaximalSquare {

    public static void main(String[] args) {
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{
                {'1','1','0','1'},
                {'1','1','0','1'},
                {'1','1','1','1'}
        }));
    }

    private int max = 0;
    private int[][] dp;
    public int maximalSquare(char[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        maximalSquare(matrix,0,0);
        return max*max;
    }

    public int maximalSquare(char[][] matrix,int i,int j) {
        if(i>=matrix.length || j>=matrix[0].length) return 0;

        if(dp[i][j]!=0) {
            return dp[i][j];
        }

        int maxSquaresLength = Math.min(maximalSquare(matrix,i+1,j), Math.min(maximalSquare(matrix,i,j+1),maximalSquare(matrix,i+1,j+1)));

        if(matrix[i][j]=='1') {
            maxSquaresLength+=1;
        }
        else {
            maxSquaresLength = 0;
        }
        dp[i][j] = maxSquaresLength;
        max = Math.max(maxSquaresLength,max);

        return maxSquaresLength;
    }
}

//link - https://leetcode.com/problems/maximal-square/submissions/

/*
Question : -
    Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */

/*
Example : -
    Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    Output: 4
 */

//level - medium

//algorithms used - dfs

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(n)