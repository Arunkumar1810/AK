package com.ak.mycode.leetcode;

public class OrangesRotting {

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        System.out.println(new OrangesRotting().orangesRotting(grid));
    }


    public int orangesRotting(int[][] grid) {

        int freshAppleCount = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == 1) {
                    freshAppleCount++;
                }
            }
        }

        int minute = 0;
        int rotNumber=2;
        while(freshAppleCount>0) {
            int currFreshAppleCount = 0;
            for(int i=0;i<grid.length;i++) {
                for(int j=0;j<grid[i].length;j++) {
                    if(grid[i][j]==(rotNumber-1)) {
                        if(!rot(grid,i,j,rotNumber)) {
                            currFreshAppleCount++;
                        }
                    }
                }
            }
            if(currFreshAppleCount==freshAppleCount) return-1;
            freshAppleCount = currFreshAppleCount;
            minute++;
            rotNumber+=2;
        }

        return minute;
    }

    public boolean rot(int[][] grid,int i,int j,int rotNumber) {

        if(((i+1)<grid.length && grid[i+1][j]==rotNumber) ||
                ((i-1)>=0 && grid[i-1][j]==rotNumber) ||
                ((j+1)<grid[i].length && grid[i][j+1]==rotNumber) ||
                ((j-1)>=0 && grid[i][j-1]==rotNumber))
        {
            grid[i][j] = rotNumber+2;
            return true;
        }
        grid[i][j] = rotNumber+1;
        return false;
    }
}
