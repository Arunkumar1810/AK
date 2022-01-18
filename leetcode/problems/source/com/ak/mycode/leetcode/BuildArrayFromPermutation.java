package com.ak.mycode.leetcode;

public class BuildArrayFromPermutation {

    public static void main(String[] args) {
        int[] result = new BuildArrayFromPermutation().buildArray(new int[]{5,0,1,2,3,4});
        for (int i : result) System.out.println(i);
    }

    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}

//link - https://leetcode.com/problems/build-array-from-permutation/

/*
Question : -
    Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
    A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
 */

/*
Example : -
    Input: nums = [0,2,1,5,3,4]
    Output: [0,1,2,4,5,3]
    Explanation: The array ans is built as follows:
    ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
        = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
        = [0,1,2,4,5,3]
 */

//level - easy

//algorithms used -

//available in lists - array-tag

//Time Complexity - O(n)

//Space Complexity - O(n)