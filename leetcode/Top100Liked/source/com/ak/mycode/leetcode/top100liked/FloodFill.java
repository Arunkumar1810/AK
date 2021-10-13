package com.ak.mycode.leetcode.top100liked;

//https://leetcode.com/problems/flood-fill/
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
