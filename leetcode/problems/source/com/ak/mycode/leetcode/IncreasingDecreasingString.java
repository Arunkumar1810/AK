package com.ak.mycode.leetcode;

public class IncreasingDecreasingString {

    public static void main(String[] args) {
        System.out.println(new Solution().sortString("aaaabbbbcccc"));
    }

    private static class Solution {
        public String sortString(String s) {
            int[] alphabets = new int[26];
            int length = s.length();
            for(char c : s.toCharArray()) {
                alphabets[c-'a']++;
            }
            StringBuilder result = new StringBuilder();
            boolean odd = true;
            while(length>0) {
                if (odd) {
                    for (int i = 0 ; i<26; i++) {
                        if(alphabets[i] <= 0) continue;
                        result.append((char)('a' + i));
                        alphabets[i]--;
                        length--;
                    }
                    odd = false;
                }
                else {
                    for (int i = 25 ; i>=0; i--) {
                        if(alphabets[i] <= 0) continue;
                        result.append((char)('a' + i));
                        alphabets[i]--;
                        length--;
                    }
                    odd = true;
                }
            }
            return String.valueOf(result);
        }
    }
}
//link - https://leetcode.com/problems/increasing-decreasing-string/

/*
Question : -
    You are given a string s. Reorder the string using the following algorithm:
        1. Pick the smallest character from s and append it to the result.
        2. Pick the smallest character from s which is greater than the last appended character to the result and append it.
        3. Repeat step 2 until you cannot pick more characters.
        4. Pick the largest character from s and append it to the result.
        5. Pick the largest character from s which is smaller than the last appended character to the result and append it.
        6. Repeat step 5 until you cannot pick more characters.
        7. Repeat the steps from 1 to 6 until you pick all characters from s.
    In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
    Return the result string after sorting s with this algorithm.
 */

/*
Example : -
    Input: s = "aaaabbbbcccc"
    Output: "abccbaabccba"
    Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
        After steps 4, 5 and 6 of the first iteration, result = "abccba"
        First iteration is done. Now s = "aabbcc" and we go back to step 1
        After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
        After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
 */

//level - easy

//algorithms used - HashTable

//available in lists - HashTable Tag

//Time Complexity - O(n)

//Space Complexity - O(1)
