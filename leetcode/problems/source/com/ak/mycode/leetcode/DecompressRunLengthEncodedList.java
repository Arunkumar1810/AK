package com.ak.mycode.leetcode;

import java.util.Arrays;

public class DecompressRunLengthEncodedList {

    public static void main(String[] args) {
        int[] result = new Solution().decompressRLElist(new int[]{
               1,2,3,4
        });
        for (int i : result) {
            System.out.println(i);
        }
    }
    private static class Solution {
        public int[] decompressRLElist(int[] nums) {
            if(nums.length % 2 != 0) return new int[0];
            int n = 0;
            for (int i=0;i+1<nums.length;i+=2) {
                n+=nums[i];
            }
            int[] result = new int[n];
            for(int i = 0, j = 0 ; i+1<nums.length; i+=2) {
                Arrays.fill(result,j,j+nums[i],nums[i+1]);
                j += nums[i];
            }
            return result;
        }
    }
}
//link - https://leetcode.com/problems/decompress-run-length-encoded-list/

/*
Question : -
    We are given a list nums of integers representing a list compressed with run-length encoding.
    Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are freq elements with value val concatenated in a sublist. Concatenate all the sublists from left to right to generate the decompressed list.
    Return the decompressed list.
 */

/*
Example : -
    Input: nums = [1,2,3,4]
    Output: [2,4,4,4]
    Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
                 The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
                 At the end the concatenation [2] + [4,4,4] is [2,4,4,4].
 */

//level - easy

//algorithms used -

//available in lists - Array Tag

//Time Complexity - O(n)

//Space Complexity - O(n)
