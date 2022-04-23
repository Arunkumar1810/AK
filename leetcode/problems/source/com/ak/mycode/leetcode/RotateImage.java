package com.ak.mycode.leetcode;

public class RotateImage {

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1,2,3},{4,5,6},{7,8,9}
        };
        new Solution().rotate(arr);
        for (int[] ints : arr) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    private static class Solution {
        public void rotate(int[][] matrix) {
            for(int i = 0; i<matrix.length; i++){
                for(int j = i; j<matrix[i].length; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            for(int i=0;i<matrix.length;i++) {
                for(int j=0;j<matrix[i].length/2;j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length-j-1];
                    matrix[i][matrix.length-j-1] = temp;
                }
            }
        }
    }
}
