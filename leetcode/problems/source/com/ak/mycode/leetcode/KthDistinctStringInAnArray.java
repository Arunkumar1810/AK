package com.ak.mycode.leetcode;

import java.util.HashMap;
import java.util.Map;

public class KthDistinctStringInAnArray {
    public static void main(String[] args) {
        System.out.println(new KthDistinctStringInAnArray().kthDistinct(new String[] {"d","b","c","b","c","a"},2));
    }

    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> hm = new HashMap<>();
        for(String string : arr) {
            int count = hm.getOrDefault(string,0);
            count++;
            hm.put(string,count);
        }

        for(String string : arr) {
            int count = hm.get(string);
            if(count==1) {
                k--;
                if(k==0) return string;
            }
        }
        return "";

    }
}

//link - https://leetcode.com/problems/kth-distinct-string-in-an-array/

/*
Question : -
    A distinct string is a string that is present only once in an array.
    Given an array of strings arr, and an integer k, return the kth distinct string present in arr. If there are fewer than k distinct strings, return an empty string "".
    Note that the strings are considered in the order in which they appear in the array.

Constraints : -
    1 <= k <= arr.length <= 1000
    1 <= arr[i].length <= 5
    arr[i] consists of lowercase English letters.
 */

/*
Example : -
    Input: arr = ["d","b","c","b","c","a"], k = 2
    Output: "a"
    Explanation:
        The only distinct strings in arr are "d" and "a".
        "d" appears 1st, so it is the 1st distinct string.
        "a" appears 2nd, so it is the 2nd distinct string.
        Since k == 2, "a" is returned.
 */

//level - easy

//algorithms used - hashmap

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(n)
