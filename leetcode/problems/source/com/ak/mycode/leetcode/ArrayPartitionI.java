package com.ak.mycode.leetcode;

import java.util.Arrays;

public class ArrayPartitionI {
    public static void main(String[] args) {
        System.out.println(new ArrayPartitionI.Solution().arrayPairSum(
                new int[] {6,2,6,5,1,2}
        ));
    }

    private static class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int result = 0;
            for(int i=0;i<nums.length;i+=2) {
                result += Math.min(nums[i], nums[i+1]);
            }
            return result;
        }
    }
}
