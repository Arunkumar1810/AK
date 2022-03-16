package com.ak.mycode.leetcode;

public class SumOfAllOddLengthSubArrays {

    public static void main(String[] args) {
        System.out.println(new Solution().sumOddLengthSubArrays(new int[] {
                1,4,2,5,3
        }));
    }

    private static class Solution {
        public int sumOddLengthSubArrays(int[] arr) {
            int n = arr.length, res = 0;
            for(int i=0;i<n;i++) {
                res += ((i + 1) * (n - i) + 1) / 2 * arr[i];
            }
            return res;
        }
    }
}
//link - https://leetcode.com/problems/sum-of-all-odd-length-subarrays/

/*
Question : -
    Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.
    A subarray is a contiguous subsequence of the array.
    Return the sum of all odd-length subarrays of arr.
 */

/*
Example : -
    Input: arr = [1,4,2,5,3]
    Output: 58
    Explanation: The odd-length subarrays of arr and their sums are:
    [1] = 1
    [4] = 4
    [2] = 2
    [5] = 5
    [3] = 3
    [1,4,2] = 7
    [4,2,5] = 11
    [2,5,3] = 10
    [1,4,2,5,3] = 15
    If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 */

//level - easy

//algorithms used -

//available in lists - Math Tag

//Time Complexity - O(n)

//Space Complexity - O(1)
