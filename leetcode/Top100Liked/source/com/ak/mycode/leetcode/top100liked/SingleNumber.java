package com.ak.mycode.leetcode.top100liked;

//https://leetcode.com/problems/single-number
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println("Sing Number : "+new SingleNumber().singleNumber(new int[]{4,1,2,1,2,0,4,0,-3}));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
