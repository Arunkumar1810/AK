package com.ak.mycode.leetcode;

public class FloodFill {

    public static void main(String[] args) {

        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        int sr = 1, sc = 1, newColour = 2;

        int[][] result = new FloodFill().floodFill(image,sr,sc,newColour);

        System.out.println("Result : ");
        for (int[] ints : result) {
            System.out.println();
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(sr<image.length && sr>=0 && sc<image[sr].length && sc>=0) {
            if(image[sr][sc] != newColor) {
                int oldColor = image[sr][sc];
                image[sr][sc] = newColor;
                image = floodFill(image,sr-1,sc,newColor,oldColor);
                image = floodFill(image,sr+1,sc,newColor,oldColor);
                image = floodFill(image,sr,sc-1,newColor,oldColor);
                image = floodFill(image,sr,sc+1,newColor,oldColor);
            }
        }
        return image;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if(sr<image.length && sr>=0 && sc<image[sr].length && sc>=0) {
            if(image[sr][sc] == oldColor) {
                image[sr][sc] = newColor;
                image = floodFill(image,sr-1,sc,newColor,oldColor);
                image = floodFill(image,sr+1,sc,newColor,oldColor);
                image = floodFill(image,sr,sc-1,newColor,oldColor);
                image = floodFill(image,sr,sc+1,newColor,oldColor);
            }
        }
        return image;
    }
}

//link - https://leetcode.com/problems/flood-fill/

/*
Question : -
    An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
    You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
    To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
    Return the modified image after performing the flood fill.
 */

/*
Example : -
    Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
    Output: [[2,2,2],[2,2,0],[2,0,1]]
    Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
        Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 */

//level - easy

//algorithms used - dfs

//available in lists - amazon-questions

//Time Complexity - O(n)

//Space Complexity - O(1)