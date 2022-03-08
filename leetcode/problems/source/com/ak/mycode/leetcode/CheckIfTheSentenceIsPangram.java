package com.ak.mycode.leetcode;

public class CheckIfTheSentenceIsPangram {
    public static void main(String[] args) {
        System.out.println(new Solution().checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(new Solution().checkIfPangram("leetcode"));
        System.out.println(new Solution().checkIfPangram("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    static class Solution {
        public boolean checkIfPangram(String sentence) {
            if(sentence.length()<26) return false;
            boolean[] alphabets = new boolean[26];
            int charsRemaining = 26;
            for(char c : sentence.toCharArray()) {
                int index = c - 'a';
                if(!alphabets[index]) {
                    alphabets[index] = true;
                    charsRemaining--;
                }
            }
            return charsRemaining == 0;
        }
    }
}
//link - https://leetcode.com/problems/check-if-the-sentence-is-pangram/

/*
Question : -
    A pangram is a sentence where every letter of the English alphabet appears at least once.
    Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 */

/*
Example : -
    Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
    Output: true
    Explanation: sentence contains at least one of every letter of the English alphabet.
 */

//level - easy

//algorithms used - Hash Table

//available in lists - Hash Table Tag

//Time Complexity - O(n) where n - size of input string

//Space Complexity - O(k) where k - maximum number of characters possible 26 in this program
