package com.ak.mycode.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {

    public static void main(String[] args) {
        System.out.println(new Solution().uniqueMorseRepresentations(new String[]
                {"gin","zen","gig","msg"}
        ));
    }
    private static class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String[] morseCode = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

            Set<String> transformations = new HashSet<>();

            for (String word : words) {
                StringBuilder sb = new StringBuilder();
                for (char c : word.toCharArray()) {
                    sb.append(morseCode[c-'a']);
                }
                transformations.add(String.valueOf(sb));
            }
            return transformations.size();
        }
    }
}
//link - https://leetcode.com/problems/unique-morse-code-words/

/*
Question : -
    International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
    'a' maps to ".-", 'b' maps to "-...", 'c' maps to "-.-.", and so on.
    For convenience, the full table for the 26 letters of the English alphabet is given below:
    [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
    Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.
    For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
    Return the number of different transformations among all words we have.
 */

/*
Example : -
    Input: words = ["gin","zen","gig","msg"]
    Output: 2
    Explanation: The transformation of each word is:
    "gin" -> "--...-."
    "zen" -> "--...-."
    "gig" -> "--...--."
    "msg" -> "--...--."
    There are 2 different transformations: "--...-." and "--...--.".
 */

//level - easy

//algorithms used - HashTable

//available in lists - HashTable Tag

//Time Complexity - O(n)

//Space Complexity - O(n)
