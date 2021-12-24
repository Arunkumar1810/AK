package com.ak.mycode.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    public static void main(String[] args) {
        WidestVerticalAreaBetweenTwoPointsContainingNoPoints obj = new WidestVerticalAreaBetweenTwoPointsContainingNoPoints();
        System.out.println(obj.maxWidthOfVerticalArea(new int[][]
                {
                        {8,7},{9,9},{7,4},{9,7}
                }));
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        int[] res = new int[points.length];
        for (int i=0;i<points.length;i++) {
            res[i] = points[i][0];
        }
        Arrays.sort(res);
        int maxWidth = 0;
        for (int i=1;i<res.length;i++) {
            int currWidth = res[i]-res[i-1];
            maxWidth = Math.max(currWidth,maxWidth);
        }
        return maxWidth;
    }
}

//link - https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/

/*
Question : -
    Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.
    A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.
    Note that points on the edge of a vertical area are not considered included in the area.
 */

/*
Example : -
    Input: points = [[8,7],[9,9],[7,4],[9,7]]
    Output: 1
    Explanation: Both the red and the blue area are optimal.
 */

//level - medium

//algorithms used -

//available in lists - sorting-tag

//Time Complexity - O(n log n)

//Space Complexity - O(n)
