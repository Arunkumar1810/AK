package com.ak.mycode.leetcode;

public class PlatesBetweenCandles {

    public static void main(String[] args) {
        int[] result = new PlatesBetweenCandles().platesBetweenCandles("***|**|*****|**||**|*" ,new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}});
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {

        if(s==null||s.isEmpty()||queries==null||queries.length<=0) return new int[0];

        char[] input = s.toCharArray();
        int[] result = new int[queries.length];
        int[] rightCalendarPositions= new int[input.length];
        int[] leftCalendarPositions= new int[input.length];
        int[] candleCountArr = new int[input.length];

        int prevPosition = -1;
        for (int i=0;i<input.length;i++) {
            if(input[i]=='|') {
                prevPosition = i;
            }
            leftCalendarPositions[i] = prevPosition;
        }

        prevPosition = -1;
        for (int i=input.length-1;i>=0;i--) {
            if(input[i]=='|') {
                prevPosition = i;
            }
            rightCalendarPositions[i] = prevPosition;
        }

        int count = 0;
        for (int i=0;i<input.length;i++) {
            if(input[i]=='|') {
                candleCountArr[i]=++count;
            }
        }

        for (int i=0;i<queries.length;i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int candleNearStart = rightCalendarPositions[start];
            int candleNearEnd = leftCalendarPositions[end];
            if(candleNearStart==-1 || candleNearEnd==-1 || candleNearStart>=candleNearEnd) result[i] = 0;
            else {
                int candleCount = candleCountArr[candleNearEnd] - candleCountArr[candleNearStart];
                result[i] = candleNearEnd - candleNearStart - candleCount;
            }
        }

        return result;
    }
}

//link - https://leetcode.com/problems/plates-between-candles/

/*
Question : -
    There is a long table with a line of plates and candles arranged on top of it. You are given a 0-indexed string s consisting of characters '*' and '|' only, where a '*' represents a plate and a '|' represents a candle.
    You are also given a 0-indexed 2D integer array queries where queries[i] = [lefti, righti] denotes the substring s[lefti...righti] (inclusive). For each query, you need to find the number of plates between candles that are in the substring. A plate is considered between candles if there is at least one candle to its left and at least one candle to its right in the substring.
    For example, s = "||**||**|*", and a query [3, 8] denotes the substring "*||**|". The number of plates between candles in this substring is 2, as each of the two plates has at least one candle in the substring to its left and right.
    Return an integer array answer where answer[i] is the answer to the ith query.

 */

/*
Example : -
    Input: s = "**|**|***|", queries = [[2,5],[5,9]]
    Output: [2,3]
    Explanation:
        queries[0] has two plates between candles.
        queries[1] has three plates between candles.
 */

//level - medium

//algorithms used - two pointer

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(n)