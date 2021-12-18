package com.ak.mycode.leetcode;

public class CountSortedVowelStrings {

    public static void main(String[] args) {
        System.out.println(new CountSortedVowelStrings().countVowelStrings(33));
    }

    public int countVowelStrings(int n) {
        int r = n;
        n=5;
        long fact1 = factorial(n+r-1,r);
        long fact3 = factorial(n-1,0);
        return (int) (fact1/fact3);
    }

    private long factorial(int start,int end) {
        if(start<=end) return 1;
        return start * factorial(start-1,end);
    }
}

//link - https://leetcode.com/problems/count-sorted-vowel-strings/submissions/

/*
Question : -
    Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
    A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
 */

/*
Example : -
    Input: n = 1
    Output: 5
    Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
 */

//level - medium

//algorithms used - dp, mathematics(combinations)

//available in lists - dp-tag

//Time Complexity - O(n)

//Space Complexity - O(1)