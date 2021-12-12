package com.ak.mycode.leetcode;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1,2,3,4,5,6,7}));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for(int i : nums) sum+=i;

        if(sum%2!=0) return false;

        sum /= 2;

        boolean[] dp = new boolean[sum+1];

        dp[0] = true;

        for (int j : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= j) {
                    dp[i] = dp[i] || dp[i-j];
                }
                if(dp[sum]) return true;
            }
        }

        return dp[sum];
    }
}

//link - https://leetcode.com/problems/partition-equal-subset-sum/

/*
Question : -
    Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Constraints:
    1 <= nums.length <= 200
    1 <= nums[i] <= 100
 */

/*
Example : -
    Input: nums = [1,5,11,5]
    Output: true
    Explanation: The array can be partitioned as [1, 5, 5] and [11].
 */

//level - medium

//algorithms used - DP

//available in lists -

//Time Complexity - O(n*(k/2)) where n-number of elements and k-sum of the elements in the array

//Space Complexity - O(k)