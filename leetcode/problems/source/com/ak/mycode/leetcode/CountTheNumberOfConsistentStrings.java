package com.ak.mycode.leetcode;

public class CountTheNumberOfConsistentStrings {

    public static void main(String[] args) {
        System.out.println(new Solution().countConsistentStrings("ab",
                new String[]{
                        "ad", "bd", "aaab", "baa", "badab"
                }));
    }

    static class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            boolean[] allowedCounter = new boolean[26];
            for(char c : allowed.toCharArray()) {
                allowedCounter[c-'a'] = true;
            }

            int result = 0;
            for (String word : words) {
                result+=1;
                for (char c : word.toCharArray()) {
                    if (!allowedCounter[c-'a']) {
                        result-=1;
                        break;
                    }
                }
            }
            return result;
        }
    }
}
//link - https://leetcode.com/problems/count-the-number-of-consistent-strings/

/*
Question : -
    You are given a string allowed consisting of distinct characters and an array of strings words.
    A string is consistent if all characters in the string appear in the string allowed.
    Return the number of consistent strings in the array words.
 */

/*
Example : -
    Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
    Output: 2
    Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
 */

//level - easy

//algorithms used - Hash Table

//available in lists - Hash Table Tag

//Time Complexity - O(n*m) where n - number of words, m - size of word

//Space Complexity - O(k) where k - number of possible characters 26 in this program
