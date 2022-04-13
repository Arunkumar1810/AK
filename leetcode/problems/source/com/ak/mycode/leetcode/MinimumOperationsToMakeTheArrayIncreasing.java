package com.ak.mycode.leetcode;

public class MinimumOperationsToMakeTheArrayIncreasing {

    public static void main(String[] args) {
        System.out.println(new MinimumOperationsToMakeTheArrayIncreasing.Solution().minOperations(
                new int[]{1,5,2,4,1}
        ));
    }

    public static class Solution {
        public int minOperations(int[] nums) {
            int result = 0;
            for(int i=1;i<nums.length;i++) {
                if(nums[i]<=nums[i-1]) {
                    result += (nums[i-1]+1-nums[i]);
                    nums[i] = nums[i-1] + 1;
                }
            }
            return result;
        }
    }
}
