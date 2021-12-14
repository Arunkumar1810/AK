package com.ak.mycode.leetcode;

public class RunningSumOf1DArray {

    public static void main(String[] args) {
        for (int i : new RunningSumOf1DArray().runningSum(new int[]{1,2,3,4})) {
            System.out.println(i);
        }
    }

    public int[] runningSum(int[] nums) {
        for(int i=1;i<nums.length;i++) {
            nums[i]+=nums[i-1];
        }
        return nums;
    }
}

//link - https://leetcode.com/problems/running-sum-of-1d-array/

/*
Question : -
    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    Return the running sum of nums.
 */

/*
Example : -
    Input: nums = [1,2,3,4]
    Output: [1,3,6,10]
    Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */

//level - easy

//algorithms used -

//available in lists - array-tag

//Time Complexity - O(n)

//Space Complexity - O(1)