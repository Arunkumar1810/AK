package com.ak.mycode.leetcode;

public class IslandPerimeter {

    public static void main(String[] args) {
        System.out.println(new Solution().islandPerimeter(
                new int[][]{
                        {0,1,0,0},
                        {1,1,1,0},
                        {0,1,0,0},
                        {1,1,0,0}
                }
        ));
    }

    private static class Solution {
        public int islandPerimeter(int[][] grid) {
            int result;
            result = grid[0][0]*4;
            for(int i=1; i<grid[0].length;i++) {
                if(grid[0][i]==1) {
                    result += 4;
                    if(grid[0][i-1]==1) result -=2;
                }
            }
            for(int i=1;i<grid.length;i++) {
                if(grid[i][0]==1) {
                    result += 4;
                    if(grid[i-1][0]==1) result -=2;
                }
            }
            for(int i = 1; i<grid.length;i++) {
                for(int j = 1; j<grid[i].length; j++) {
                    if(grid[i][j]==1) {
                        result += grid[i][j]*4;
                        if(grid[i-1][j]==1) result-=2;
                        if(grid[i][j-1]==1) result-=2;

                    }
                }
            }
            return result;
        }
    }
}
