package com.ak.mycode.leetcode;

public class NumberComplement {

    public static void main(String[] args) {
        System.out.println(new NumberComplement().findComplement(5));
    }

    public int findComplement(int num) {
        int result =0;
        int dig=0;
        while(num>0) {
            int bit = num%2;
            bit = bit==0?1:0;
            num = num/2;
            result += (bit*Math.pow(2,dig++));
        }
        return result;
    }
}

//link - https://leetcode.com/problems/number-complement/

/*
Question : -
    The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
    For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
    Given an integer num, return its complement.
 */

/*
Example : -
    Input: num = 5
    Output: 2
    Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 */

//level - easy

//algorithms used -

//available in lists -

//Time Complexity - O(log n)

//Space Complexity - O(1)