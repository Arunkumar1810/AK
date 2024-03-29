package com.ak.mycode.leetcode;

public class MaxIncreaseToKeepCitySkyline {

    public static void main(String[] args) {
        MaxIncreaseToKeepCitySkyline obj = new MaxIncreaseToKeepCitySkyline();
        int[][] grid = new int[][]{
                {8, 4, 8, 7},
                {7, 4, 7, 7},
                {9, 4, 8, 7},
                {3, 3, 3, 3}
        };
        System.out.println(obj.maxIncreaseKeepingSkyline(grid));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }

        int addedCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                addedCount += (Math.max(grid[i][j], Math.min(rowMax[i], colMax[j])) - grid[i][j]);
            }
        }

        return addedCount;
    }
}

//link - https://leetcode.com/problems/max-increase-to-keep-city-skyline/

/*
Question : -
    There is a city composed of n x n blocks, where each block contains a single building shaped like a vertical square prism. You are given a 0-indexed n x n integer matrix grid where grid[r][c] represents the height of the building located in the block at row r and column c.
    A city's skyline is the the outer contour formed by all the building when viewing the side of the city from a distance. The skyline from each cardinal direction north, east, south, and west may be different.
    We are allowed to increase the height of any number of buildings by any amount (the amount can be different per building). The height of a 0-height building can also be increased. However, increasing the height of a building should not affect the city's skyline from any cardinal direction.
    Return the maximum total sum that the height of the buildings can be increased by without changing the city's skyline from any cardinal direction.
 */

/*
Example : -
    Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
    Output: 35
    Explanation: The building heights are shown in the center of the above image.
        The skylines when viewed from each cardinal direction are drawn in red.
    The grid after increasing the height of buildings without affecting skylines is:
    gridNew = [ [8, 4, 8, 7],
                [7, 4, 7, 7],
                [9, 4, 8, 7],
                [3, 3, 3, 3] ]
 */

//level - medium

//algorithms used - greedy

//available in lists - greedy-tag

//Time Complexity - O(m*n)

//Space Complexity - O(m+n)