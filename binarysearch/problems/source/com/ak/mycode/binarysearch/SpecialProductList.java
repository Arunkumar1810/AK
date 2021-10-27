package com.ak.mycode.binarysearch;

import java.util.Arrays;

//https://binarysearch.com/problems/Special-Product-List

//Array

//two pointers

//medium

public class SpecialProductList {

    public static void main(String[] args) {
        int[] result = new SpecialProductList().solve(new int[]{1, 2, 3, 4, 5});
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] solve(int[] nums) {
        int[] result = new int[nums.length];
        int frontVal = 1;
        int backVal = 1;
        Arrays.fill(result,1);
        for (int i = 0,j=nums.length-1 ; i<nums.length && j>=0;i++,j--) {
            result[i] = result[i] * frontVal;
            frontVal = nums[i] * frontVal;

            result[j] = result[j] * backVal ;
            backVal = nums[j] * backVal;

        }
        return result;
    }
}
