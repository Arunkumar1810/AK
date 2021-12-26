package com.ak.mycode.leetcode;

import java.util.Arrays;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        int[][] result = new KClosestPointsToOrigin().kClosest(new int[][]
                {{3,3},{5,-1},{-2,4}},2);

        for (int[] point: result) System.out.println(point[0]+"\t"+point[1]);
    }

    public int[][] kClosest(int[][] points, int k) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == k) break;
            if (mid < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    private int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0) r--;
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0) l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}

//link - https://leetcode.com/problems/k-closest-points-to-origin/

/*
Question : -
    Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
    The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
    You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 */

/*
Example : -
    Input: points = [[1,3],[-2,2]], k = 1
    Output: [[-2,2]]
    Explanation:
        The distance between (1, 3) and the origin is sqrt(10).
        The distance between (-2, 2) and the origin is sqrt(8).
        Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
        We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 */

//level - medium

//algorithms used -

//available in lists -

//Time Complexity - O(n log n)

//Space Complexity - O(k)