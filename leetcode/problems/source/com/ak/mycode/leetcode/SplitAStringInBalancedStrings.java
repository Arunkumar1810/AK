package com.ak.mycode.leetcode;

public class SplitAStringInBalancedStrings {

    public static void main(String[] args) {
        SplitAStringInBalancedStrings obj = new SplitAStringInBalancedStrings();
        System.out.println(obj.balancedStringSplit("RLRRLLRLRL"));
    }

    public int balancedStringSplit(String s) {
        int countOfR=0,countOfL=0,result=0;
        for(char c : s.toCharArray()) {
            if(c=='R') countOfR++;
            if(c=='L') countOfL++;
            if(countOfR==countOfL) {
                result++;
                countOfR=0;
                countOfL=0;
            }
        }
        return result;
    }
}

//link - https://leetcode.com/problems/split-a-string-in-balanced-strings/

/*
Question : -
    Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
    Given a balanced string s, split it in the maximum amount of balanced strings.
    Return the maximum amount of split balanced strings.
 */

/*
Example : -
    Input: s = "RLRRLLRLRL"
    Output: 4
    Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 */

//level - easy

//algorithms used - greedy

//available in lists - greedy-tag

//Time Complexity - O(n)

//Space Complexity - O(1)