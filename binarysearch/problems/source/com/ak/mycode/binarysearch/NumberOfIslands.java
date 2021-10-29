package com.ak.mycode.binarysearch;

//https://binarysearch.com/problems/Number-of-Islands

//medium

//graph

//Your code took 36 milliseconds — faster than 81.59% in Java

// Top Interview Questions

public class NumberOfIslands {
    public static void main(String[] args) {
        System.out.println(new NumberOfIslands().solve(
                new int[][]{
                        {1, 0, 0, 0, 0},
                        {0, 0, 1, 1, 0},
                        {0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 1},
                        {1, 1, 0, 0, 1}
                }
        ));
    }

    public int solve(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int numberOfIslands = 0;
        for (int i = 0 ; i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++) {
                if(matrix[i][j] == 1) {
                    numberOfIslands += dfs(matrix,i,j);
                }
            }
        }
        return numberOfIslands;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[i].length || matrix[i][j]==0) {
            return 0;
        }

        matrix[i][j] = 0;
        dfs(matrix,i-1,j);
        dfs(matrix,i+1,j);
        dfs(matrix,i,j-1);
        dfs(matrix,i,j+1);
        return 1;
    }


}
