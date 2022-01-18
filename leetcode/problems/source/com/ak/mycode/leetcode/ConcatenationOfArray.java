package com.ak.mycode.leetcode;

public class ConcatenationOfArray {

    public static void main(String[] args) {
        int[] results = new ConcatenationOfArray().getConcatenation(new int[]{1,3,2,1});
        for (int i : results) System.out.println(i);
    }

    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length*2];
        for (int i=0;i<nums.length;i++) {
            ans[i] = nums[i];
            ans[i+1] = nums[i];
        }
        return ans;
    }
}

//link - https://leetcode.com/problems/concatenation-of-array/

/*
Question : -
    Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
    Specifically, ans is the concatenation of two nums arrays.
    Return the array ans.
 */

/*
Example : -
    Input: nums = [1,2,1]
    Output: [1,2,1,1,2,1]
    Explanation: The array ans is formed as follows:
    - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
    - ans = [1,2,1,1,2,1]
 */

//level - easy

//algorithms used -

//available in lists - array-tag

//Time Complexity - O(n)

//Space Complexity - O(n)
