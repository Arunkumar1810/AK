package com.ak.mycode.leetcode;

public class ShuffleString {

    public static void main(String[] args) {
        System.out.println(new ShuffleString().restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
    }
    public String restoreString(String s, int[] indices) {
        char[] result = new char[indices.length];
        for(int i=0;i<result.length;i++) {
            result[indices[i]] = s.charAt(i);
        }
        return new String(result);
    }
}

//link - https://leetcode.com/problems/shuffle-string/

/*
Question : -
    You are given a string s and an integer array indices of the same length. The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
    Return the shuffled string.
 */

/*
Example : -
    Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
    Output: "leetcode"
    Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
 */

//level - easy

//algorithms used -

//available in lists - string-tag

//Time Complexity - O(n)

//Space Complexity - O(n)