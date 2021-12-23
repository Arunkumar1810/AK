package com.ak.mycode.leetcode;

public class CountSquareSubMatricesWithAllOnes {

    public static void main(String[] args) {
        System.out.println(new CountSquareSubMatricesWithAllOnes().countSquares(new int[][]{
                {0,0,0},{0,1,0},{0,1,0},{1,1,1},{1,1,0}
        }));
    }

    public int countSquares(int[][] matrix) {
        int result = 0;
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++) {
                if(i>0 && j>0 && matrix[i][j]>0) {
                    matrix[i][j] += Math.min(matrix[i-1][j-1],Math.min(matrix[i][j-1],matrix[i-1][j]));
                }
                result+=matrix[i][j];
            }
        }
        return result;
    }
}

//link - https://leetcode.com/problems/count-square-submatrices-with-all-ones/

/*
Question : -
    Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 */

/*
Example : -
    Input: matrix =
    [
        [0,1,1,1],
        [1,1,1,1],
        [0,1,1,1]
    ]
    Output: 15
    Explanation:
        There are 10 squares of side 1.
        There are 4 squares of side 2.
        There is  1 square of side 3.
        Total number of squares = 10 + 4 + 1 = 15.
 */

//level - medium

//algorithms used - dp

//available in lists - dp-tag

//Time Complexity - O(n)

//Space Complexity - O(1)