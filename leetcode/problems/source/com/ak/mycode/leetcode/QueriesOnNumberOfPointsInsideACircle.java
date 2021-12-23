package com.ak.mycode.leetcode;

public class QueriesOnNumberOfPointsInsideACircle {

    public static void main(String[] args) {
        int[] result = new QueriesOnNumberOfPointsInsideACircle().countPoints(
                new int[][] {{1,3},{3,3},{5,3},{2,2}},
                new int[][] {{2,3,1},{4,3,1},{1,1,2}}
        );
        for (int i : result) System.out.println(i);
    }

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        int i=0;
        for(int[] query : queries) {
            int count=0;
            for(int[] point : points) {
                int x = point[0] - query[0];
                int y = point[1] - query[1];
                if(x*x + y*y <= query[2]*query[2]) {
                    count++;
                }
            }
            result[i++] = count;
        }
        return result;
    }
}

//link - https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/

/*
Question : -
    You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.
    You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.
    For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.
    Return an array answer, where answer[j] is the answer to the jth query.
 */

/*
Example : -
    Input: points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
    Output: [3,2,2]
    Explanation: The points and circles are shown above.
    queries[0] is the green circle, queries[1] is the red circle, and queries[2] is the blue circle.
 */

//level - medium

//algorithms used - math(Pythagoras Theorem)

//available in lists - math-tag

//Time Complexity - O(q.l*p.l)

//Space Complexity - O(n)
