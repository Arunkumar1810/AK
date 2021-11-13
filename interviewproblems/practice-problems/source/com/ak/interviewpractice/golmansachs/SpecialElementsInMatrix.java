package com.ak.interviewpractice.golmansachs;

//https://www.csestack.org/coding-challenge-special-elements-in-matrix/

//medium

//dynamic programming

//O(n) n is the number of elements in the matrix

//Goldman Sachs Practice

public class SpecialElementsInMatrix {

    public static void main(String[] args) {
        System.out.println(new SpecialElementsInMatrix().solve(
                new int[][]
                        {
                                {1,3,4},
                                {5,2,9},
                                {8,7,6}
                        }
        ));
    }

    private int solve(int[][] matrix) {

        boolean[][] result = new boolean[matrix.length][matrix.length];
        int count = 0;

        //getting special element row wise
        for (int i = 0;i<matrix.length;i++) {
            int minElementIndex = 0;
            int maxElementIndex = 0;
            for (int j = 1;j<matrix[i].length;j++) {
                if(matrix[i][j]<matrix[i][minElementIndex]) {
                    minElementIndex = j;
                }
                if(matrix[i][j]>matrix[i][maxElementIndex]) {
                    maxElementIndex = j;
                }
                result[i][j] = false;
            }
            result[i][minElementIndex] = true;
            result[i][maxElementIndex] = true;
            count+=2;
        }

        //getting special element column wise
        for (int i = 0;i<matrix.length;i++) {
            int minElementIndex = 0;
            int maxElementIndex = 0;
            for (int j = 1;j<matrix[i].length;j++) {
                if(matrix[i][j]<matrix[i][minElementIndex]) {
                    minElementIndex = j;
                }
                if(matrix[i][j]>matrix[j][maxElementIndex]) {
                    maxElementIndex = j;
                }
            }
            if(!result[i][minElementIndex]) {
                result[i][minElementIndex] = true;
                count++;
            }
            if(!result[i][maxElementIndex]) {
                result[i][maxElementIndex] = true;
                count += 1;
            }
        }

        return count;
    }
}
