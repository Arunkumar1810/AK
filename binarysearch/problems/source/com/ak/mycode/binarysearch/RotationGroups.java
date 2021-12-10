package com.ak.mycode.binarysearch;

import java.util.HashSet;

public class RotationGroups {

    public static void main(String[] args) {
        System.out.println(new RotationGroups().solve(new String[]{"abc", "xy", "yx", "z", "bca"}));
        System.out.println(new RotationGroups().solve2(new String[]{"abc", "xy", "yx", "z", "bca"}));
    }

    //O(n^2)
    public int solve(String[] words) {
        int result = 0;
        HashSet<String> strings = new HashSet<>();
        for (String string : words) {
            boolean isExist = false;
            for (String rotatedString : strings) {
                if(rotatedString.length()==2*string.length() && rotatedString.contains(string)) {
                    isExist = true;
                    break;
                }
            }
            if(!isExist) {
                strings.add(string+string);
                result++;
            }
        }
        return result;
    }

    //O(n*k)
    public int solve2(String[] words) {
        HashSet<String> rotates = new HashSet<>();
        int result=0;
        for(String word : words) {
            if(!rotates.contains(word)) {
                result++;
                int n = word.length();
                for(int i = 0 ; i<n ; i++) {
                    rotates.add(word.substring(n-i-1)+word.substring(0,n-i-1));
                }
            }
        }
        return result;
    }
}

//link - https://binarysearch.com/problems/Rotation-Groups

/*
Question : -
    A rotation group for a string contains all of its unique rotations. For example, "123" can be rotated to "231" and "312" and they are all in the same rotation group.
    Given a list of strings words, group each word by their rotation group, and return the total number of groups.

Constraints
    n ≤ 200 where n is the length of words.
 */

/*
Example : -
    Input
        words = ["abc", "xy", "yx", "z", "bca"]
    Output
        3
    Explanation
        There are three rotation groups:

        ["abc", "bca"]
        ["xy", "yx"]
        ["z"]

 */

//level - easy

//algorithms used - hash table

//available in lists - Top Interview Problems, Amazon, Facebook, Uber, Google

//Time Complexity - 1. O(n^2), 2. O(n*k)

//Space Complexity - 1. O(n), 2. O(n*k)
