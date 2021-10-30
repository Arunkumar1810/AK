package com.ak.mycode.binarysearch;


//https://binarysearch.com/problems/Toeplitz-Matrix

//easy

//2D-Array

//Your code took 14 milliseconds — faster than 100.00% in Java

//Top 100 Liked Problems

public class ToeplitzMatrix {

    public static void main(String[] args) {
        System.out.println(new ToeplitzMatrix().solve(
                new int[][]{
                        {0, 1, 2},
                        {3, 0, 1},
                        {1, 3, 0},
                        {5, 4, 3}
                }
        ));
    }

    public boolean solve(int[][] matrix) {
        for (int i=0;i<matrix.length;i++) {
            int num = matrix[i][0];
            for (int k=i+1,j=1; k<matrix.length && j<matrix[k].length;k++,j++) {
                if(num!=matrix[k][j]) {
                    return false;
                }
            }
        }

        for (int j=0;j<matrix[0].length;j++) {
            int num = matrix[0][j];
            for (int k=j+1,i=1; i<matrix.length && k<matrix[i].length;k++,i++) {
                if(num!=matrix[i][k]) {
                    return false;
                }
            }
        }

        return true;
    }
}
