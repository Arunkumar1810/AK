package com.ak.mycode.binarysearch;

import java.util.HashMap;

public class RepeatedKLengthSubstrings {

    public static void main(String[] args) {
        System.out.println(new RepeatedKLengthSubstrings().solve("abcdabc",3));
    }

    public int solve(String s, int k) {
        HashMap<String,Integer> hashSet = new HashMap<>();
        int count = 0;
        for (int i=0;i+k<=s.length();i++) {
            String key = s.substring(i,i+k);
            if(!hashSet.containsKey(key)) {
                hashSet.put(key,1);
            }
            else {
                if(hashSet.get(key)==1) {
                    count++;
                    hashSet.put(key,2);
                }
            }
        }
        return count;
    }
}

//link - https://binarysearch.com/problems/Repeated-K-Length-Substrings

/*
Question : -
    Given a string s and an integer k, return the number of k-length substrings that occur more than once in s.

Constraints
    n ≤ 100,000 where n is the length of s.
    k ≤ 10
 */

/*
Example : -
    Input
        s = "abcdabc"
        k = 3
    Output
        1
 */

//level - easy

//algorithms used - hash map

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(n)
