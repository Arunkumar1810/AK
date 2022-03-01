package com.ak.mycode.leetcode;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    public static void main(String[] args) {
        int[] result = new MinimumNumberOfOperationsToMoveAllBallsToEachBox().minOperations("001011");
        for (int i: result) {
            System.out.println(i);
        }
    }

    public int[] minOperations(String boxes) {
        char[] input = boxes.toCharArray();
        int[] fromFrontCost = new int[input.length];
        fromFrontCost[0] = 0;
        int cnt = input[0] - '0';
        for(int i=1;i<input.length;i++) {
            fromFrontCost[i] = fromFrontCost[i-1] + cnt;
            cnt = cnt + (input[i]-'0');
        }

        int[] fromBackCost = new int[input.length];
        fromBackCost[input.length-1] = 0;
        cnt = input[input.length-1] - '0';
        for(int i=input.length-2;i>=0;i--) {
            fromBackCost[i] = fromBackCost[i+1] + cnt;
            cnt = cnt + (input[i]-'0');
        }

        for(int i=0; i<input.length;i++) {
            fromFrontCost[i] = fromFrontCost[i] + fromBackCost[i];
        }

        return fromFrontCost;
    }
}
//link - https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

/*
Question : -
    You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
    In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
    Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
    Each answer[i] is calculated considering the initial state of the boxes.
 */

/*
Example : -
    Input: boxes = "110"
    Output: [1,1,3]
    Explanation: The answer for each box is as follows:
        1) First box: you will have to move one ball from the second box to the first box in one operation.
        2) Second box: you will have to move one ball from the first box to the second box in one operation.
        3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
 */

//level - medium

//algorithms used - two pointer

//available in lists - string tag

//Time Complexity - O(n)

//Space Complexity - O(n)
