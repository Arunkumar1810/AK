package com.ak.mycode.leetcode;

public class CountNumberOfPairsWithAbsoluteDifferenceK {
    public static void main(String[] args) {
        System.out.println(new CountNumberOfPairsWithAbsoluteDifferenceK().countKDifference(
                new int[]{1,2,2,1},
                1
        ));
    }

    public int countKDifference(int[] nums, int k) {
        int result =0;
        int[] counter = new int[101];
        for(int i=0;i<nums.length;i++)
        {
            counter[nums[i]]++;
        }

        for(int i=1;(i+k)<101;i++) {
            result += (counter[i] * counter[i+k]);
        }
        return result;
    }
}
//link - https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/

/*
Question : -
    Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j such that |nums[i] - nums[j]| == k.
    The value of |x| is defined as:
        x if x >= 0.
        -x if x < 0.
 */

/*
Example : -
    Input: nums = [1,2,2,1], k = 1
    Output: 4
    Explanation: The pairs with an absolute difference of 1 are:
        - [1,2,2,1]
        - [1,2,2,1]
        - [1,2,2,1]
        - [1,2,2,1]
 */

//level - easy

//algorithms used - Hash Table

//available in lists - Hash Table Tag

//Time Complexity - O(n) + O(k) where n - number of elements in the array, k - max possible value 100 in this program

//Space Complexity - O(k) where k - max possible value 100 in this program
