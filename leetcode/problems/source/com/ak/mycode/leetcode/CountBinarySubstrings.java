package com.ak.mycode.leetcode;

public class CountBinarySubstrings {

    public static void main(String[] args) {
        System.out.println(new CountBinarySubstrings().countBinarySubstrings("00110011"));
    }

    public int countBinarySubstrings(String s) {
        int prevRunLength = 0, curRunLength = 1, res = 0;
        char[] charArray = s.toCharArray();
        for (int i=1;i<s.length();i++) {
            if (charArray[i] == charArray[i-1]) curRunLength++;
            else {
                prevRunLength = curRunLength;
                curRunLength = 1;
            }
            if (prevRunLength >= curRunLength) res++;
        }
        return res;
    }
}

//link - https://leetcode.com/problems/count-binary-substrings/

/*
Question : -
    Give a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
    Substrings that occur multiple times are counted the number of times they occur.
 */

/*
Example : -
    Input: s = "00110011"
Output: 6
    Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
        Notice that some of these substrings repeat and are counted the number of times they occur.
        Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 */

//level - easy

//algorithms used - two pointer

//available in lists - amazon-questions

//Time Complexity - O(n)

//Space Complexity - O(1)