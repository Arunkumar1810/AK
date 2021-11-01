package com.ak.mycode.binarysearch;

//https://binarysearch.com/problems/Sudoku-Validator

//medium

//2D-Array

//Your code took 4 milliseconds — faster than 99.67% in Java

//Top Interview Problems

public class SudokuValidator {
    public static void main(String[] args) {
        System.out.println(new SudokuValidator().solve(new int[][]
                {
                        {0, 2, 6, 5, 7, 1, 3, 20, 8},
                        {8, 5, 7, 2, 9, 3, 1, 4, 6},
                        {1, 3, 9, 4, 6, 8, 2, 7, 5},
                        {9, 7, 1, 3, 8, 5, 6, 2, 4},
                        {5, 4, 3, 7, 2, 6, 8, 1, 9},
                        {6, 8, 2, 1, 4, 9, 7, 5, 3},
                        {7, 9, 4, 6, 3, 2, 5, 8, 1},
                        {2, 6, 5, 8, 1, 4, 9, 3, 7},
                        {3, 1, 8, 9, 5, 7, 4, 6, 2}
                }));
    }

    public boolean solve(int[][] matrix) {
        for (int[] ints : matrix) {
            int[] nums = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                if(ints[j] - 1 >= nums.length || ints[j] - 1 < 0) return false;
                if (nums[ints[j] - 1] == 0) {
                    nums[ints[j] - 1] = -1;
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int[] nums = new int[matrix.length];
            for (int[] ints : matrix) {
                if(ints[i] - 1 >= nums.length || ints[i] - 1 < 0) return false;
                if (nums[ints[i] - 1] == 0) {
                    nums[ints[i] - 1] = -1;
                } else {
                    return false;
                }
            }
        }
        int boxSize = (int) Math.sqrt(matrix.length);
        for (int i = 0 ; i < boxSize ; i++) {
            int[] nums = new int[matrix.length];
            for (int j=i*boxSize;j<(i+1)*boxSize;j++) {
                for (int k=i*boxSize;k<(i+1)*boxSize;k++) {
                    if(matrix[j][k]-1 >= nums.length || matrix[j][k]-1<0) return false;
                    if(nums[matrix[j][k]-1] == 0) {
                        nums[matrix[j][k]-1] = -1;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
