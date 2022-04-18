package com.ak.mycode.leetcode;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        System.out.println(new Solution().maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
    }

    private static class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int maxArea = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != 0) {
                        maxArea = Math.max(maxArea, getIslandArea(grid, i, j));
                    }
                }
            }
            return maxArea;
        }

        public int getIslandArea(int[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) return 0;
            int area = 1;
            grid[i][j] = 0;
            area += getIslandArea(grid, i + 1, j);
            area += getIslandArea(grid, i - 1, j);
            area += getIslandArea(grid, i, j + 1);
            area += getIslandArea(grid, i, j - 1);
            return area;
        }
    }
}
