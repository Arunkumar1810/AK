package com.ak.mycode.leetcode;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {

    public static void main(String[] args) {
        System.out.println(new MinimizeMaximumPairSumInArray().minPairSum(new int[]{3,5,4,2,4,6}));
    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for(int i=0,j=nums.length-1;i<j;i++,j--) {
            max = Math.max((nums[i]+nums[j]),max);
        }
        return max;
    }
}

//link - https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/

/*
Question : -
    The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.
    For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
    Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:
    Each element of nums is in exactly one pair, and
    The maximum pair sum is minimized.
    Return the minimized maximum pair sum after optimally pairing up the elements.
 */

/*
Example : -
    Input: nums = [3,5,2,3]
    Output: 7
    Explanation: The elements can be paired up into pairs (3,3) and (5,2).
        The maximum pair sum is max(3+3, 5+2) = max(6, 7) = 7.
 */

//level - medium

//algorithms used - greedy, sorting

//available in lists - greedy-tag

//Time Complexity - O(n log n)

//Space Complexity - O(1)