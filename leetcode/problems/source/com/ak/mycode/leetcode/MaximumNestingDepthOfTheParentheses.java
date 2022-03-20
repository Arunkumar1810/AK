package com.ak.mycode.leetcode;

public class MaximumNestingDepthOfTheParentheses {

    public static void main(String[] args) {
        System.out.println(new Solution().maxDepth("(1+(2*3)+((8)/4))+1"));
    }

    private static class Solution {
        public int maxDepth(String s) {
            int numOfLeftBrackets = 0, numOfRightBrackets = 0, maxDepth = 0;
            for(char c : s.toCharArray()) {
                if(c == '(') {
                    numOfLeftBrackets++;
                    continue;
                }
                int depth = numOfLeftBrackets - numOfRightBrackets;
                maxDepth = Math.max(depth,maxDepth);
                if(c == ')') numOfRightBrackets++;
            }
            return maxDepth;
        }
    }
}
//link - https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

/*
Question : -
    A string is a valid parentheses string (denoted VPS) if it meets one of the following:
        It is an empty string "", or a single character not equal to "(" or ")",
        It can be written as AB (A concatenated with B), where A and B are VPS's, or
        It can be written as (A), where A is a VPS.

    We can similarly define the nesting depth depth(S) of any VPS S as follows:
        depth("") = 0
        depth(C) = 0, where C is a string with a single character not equal to "(" or ")".
        depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's.
        depth("(" + A + ")") = 1 + depth(A), where A is a VPS.

    For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
    Given a VPS represented as string s, return the nesting depth of s.
 */

/*
Example : -
    Input: s = "(1+(2*3)+((8)/4))+1"
    Output: 3
    Explanation: Digit 8 is inside of 3 nested parentheses in the string.
 */

//level - easy

//algorithms used -

//available in lists - String Tag

//Time Complexity - O(n)

//Space Complexity - O(1)
