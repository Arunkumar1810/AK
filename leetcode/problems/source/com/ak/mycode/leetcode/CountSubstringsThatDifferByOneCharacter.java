package com.ak.mycode.leetcode;

public class CountSubstringsThatDifferByOneCharacter {

    public static void main(String[] args) {
        System.out.println(
                new Solution().countSubstrings("aba","baba")
        );
    }

    private static class Solution {
        public int countSubstrings (String s, String t) {
            int res = 0;
            for (int i=0; i<s.length();i++) {
                res+=helper(s,t,i,0);
            }

            for (int j=0; j<t.length();j++) {
                res+=helper(s,t,0,j);
            }
            return res;
        }

        private int helper(String s, String t, int i, int j) {
            int sizeOfCurrSameChars = 0, sizeOfPrevSameChars = 0, result =0;
            for (int m = s.length(),n = t.length(); i<m&&j<n ;i++,j++) {
                sizeOfCurrSameChars++;
                if(s.charAt(i)==t.charAt(j)) {
                    sizeOfPrevSameChars = sizeOfCurrSameChars;
                    sizeOfCurrSameChars = 0;
                }
                result+=sizeOfPrevSameChars;
            }
            return result;
        }


    }
}
//link - https://leetcode.com/problems/count-substrings-that-differ-by-one-character/

/*
Question : -
    Given two strings s and t, find the number of ways you can choose a non-empty substring of s and replace a single character by a different character such that the resulting substring is a substring of t. In other words, find the number of substrings in s that differ from some substring in t by exactly one character.
    For example, the underlined substrings in "computer" and "computation" only differ by the 'e'/'a', so this is a valid way.
    Return the number of substrings that satisfy the condition above.
    A substring is a contiguous sequence of characters within a string.
 */

/*
Example : -
    Input: s = "ab", t = "bb"
    Output: 3
    Explanation: The following are the pairs of substrings from s and t that differ by 1 character:
    ("ab", "bb")
    ("ab", "bb")
    ("ab", "bb")
    The underlined portions are the substrings that are chosen from s and t.
 */

//level - medium

//algorithms used - sliding window

//available in lists - dp tag

//Time Complexity - O(n*m)

//Space Complexity - O(1)
