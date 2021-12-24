package com.ak.mycode.leetcode;

public class XOROperationInAnArray {

    public static void main(String[] args) {
        System.out.println(new XOROperationInAnArray().xorOperation(4,3));
    }

    public int xorOperation(int n, int start) {
        if(n==0) return 0;
        int result = start;
        for(int i=1;i<n;i++) {
            result = result ^ (start + 2*i);
        }
        return result;
    }
}

//link - https://leetcode.com/problems/xor-operation-in-an-array/

/*
Question : -
    You are given an integer n and an integer start.
    Define an array nums where nums[i] = start + 2 * i (0-indexed) and n == nums.length.
    Return the bitwise XOR of all elements of nums.
 */

/*
Example : -
    Input: n = 5, start = 0
    Output: 8
    Explanation: Array nums is equal to [0, 2, 4, 6, 8] where (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8.
        Where "^" corresponds to bitwise XOR operator.
 */

//level - easy

//algorithms used -

//available in lists - math-tag

//Time Complexity - O(n);

//Space Complexity - O(1)