package com.ak.mycode.leetcode;

public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.print(new PowerOfTwo().isPowerOfTwo(3));
    }

    public boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n)==1;
    }
}

//link - https://leetcode.com/problems/power-of-two/

/*
Question : -
    Given an integer n, return true if it is a power of two. Otherwise, return false.
    An integer n is a power of two, if there exists an integer x such that n == 2^x.
 */

/*
Example : -
    Input: n = 16
    Output: true
    Explanation: 2^4 = 16
 */

//level - easy

//algorithms used -

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(1)