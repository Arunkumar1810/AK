package com.ak.mycode.leetcode;

public class GameOfLife {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        new Solution().gameOfLife(matrix);
        for (int[] ints : matrix) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    private static class Solution {
        public void gameOfLife(int[][] board) {
            for(int i=0;i<board.length;i++) {
                for(int j=0;j<board[i].length;j++) {
                    int liveNeighbors = getLiveNeighbors(board,i,j);
                    if(board[i][j]==1) {
                        if(liveNeighbors<2) board[i][j]=2;
                        if(liveNeighbors>3) board[i][j]=2;
                    }
                    else {
                        if(liveNeighbors==3) board[i][j]=3;
                    }
                }
            }

            for(int i=0;i<board.length;i++) {
                for(int j=0;j<board[i].length;j++) {
                    if(board[i][j]==3) {
                        board[i][j]=1;
                    }
                    else if(board[i][j]==2) {
                        board[i][j]=0;
                    }
                }
            }
        }

        public int getLiveNeighbors(int[][] board, int i, int j) {
            int liveNeighbors = 0;
            if(i-1>=0) {
                if(j-1>=0 && (board[i-1][j-1]==1 || board[i-1][j-1]==2)) liveNeighbors++;
                if(board[i-1][j]==1 || board[i-1][j]==2) liveNeighbors++;
                if(j+1<board[i-1].length && (board[i-1][j+1]==1 || board[i-1][j+1]==2)) liveNeighbors++;
            }

            if(j-1>=0 && (board[i][j-1]==1 || board[i][j-1]==2)) liveNeighbors++;
            if(j+1<board[i].length && board[i][j+1]==1) liveNeighbors++;

            if(i+1<board.length) {
                if(j-1>=0 && board[i+1][j-1]==1) liveNeighbors++;
                if(board[i+1][j]==1) liveNeighbors++;
                if(j+1<board[i+1].length && board[i+1][j+1]==1) liveNeighbors++;
            }
            return liveNeighbors;
        }
    }
}
