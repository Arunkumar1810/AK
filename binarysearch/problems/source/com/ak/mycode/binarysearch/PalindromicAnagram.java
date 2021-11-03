package com.ak.mycode.binarysearch;

import java.util.HashMap;

//https://binarysearch.com/problems/Palindromic-Anagram

//medium

//hash table

//Your code took 6 milliseconds — faster than 95.53% in Java

//Top Interview Problems

public class PalindromicAnagram {
    public static void main(String[] args) {
        System.out.println(new PalindromicAnagram().solveForLowerCaseEnglishChars("carrace"));
    }

    public boolean solveForLowerCaseEnglishChars(String s) {
        char[] input = s.toCharArray();
        int[] chars = new int[26];
        int oddCharsCount = 0;
        for (char c : input) {
            int count = chars[c-'a'];
            if (count % 2 == 0) {
                oddCharsCount += 1;
            } else {
                oddCharsCount -= 1;
            }
            chars[c-'a']++;
        }
        return oddCharsCount<=1;
    }

    public boolean solveForAllChars(String s) {
        char[] input = s.toCharArray();
        HashMap<Character,Integer> charToOccurrence = new HashMap<>();
        int oddCharsCount = 0;
        for (char c : input) {
            int count = charToOccurrence.getOrDefault(c, 0);
            if (count % 2 == 0) {
                oddCharsCount += 1;
            } else {
                oddCharsCount -= 1;
            }
            charToOccurrence.put(c, count + 1);
        }

        return oddCharsCount<=1;
    }
}
