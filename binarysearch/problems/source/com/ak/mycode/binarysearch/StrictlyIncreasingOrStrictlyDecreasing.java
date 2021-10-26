package com.ak.mycode.binarysearch;

//https://binarysearch.com/problems/Strictly-Increasing-or-Strictly-Decreasing
public class StrictlyIncreasingOrStrictlyDecreasing {

    public static void main(String[] args) {
        System.out.print(new StrictlyIncreasingOrStrictlyDecreasing().solve(new int[]{1, 2, 3, 4, 5}));
    }

    public boolean solve(int[] nums) {
        if(nums.length>1) {
            if(nums[0] == nums[1]) {
                return false;
            }
            boolean isStrictlyIncreasing = nums[0] < nums[1];
            for (int i = 2 ; i < nums.length ; i++) {
                if(nums[i] > nums[i-1] && !isStrictlyIncreasing) {
                    return false;
                }
                else if (nums[i] < nums[i-1] && isStrictlyIncreasing) {
                    return false;
                }
                else if(nums[i] == nums[i-1]) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
}
