package com.ak.mycode.binarysearch;

//https://binarysearch.com/problems/Rain-Catcher

//medium

//two pointer

//Your code took 104 milliseconds — faster than 99.53% in Java

// Top Interview Questions

public class RainCatcher {

    public static void main(String[] args) {
        System.out.println(new RainCatcher().solve(new int[]{0,1,2}));
    }

    public int solve(int[] nums) {
        if(nums.length<=2) return 0;
        int result = 0;
        int i = 0,j=nums.length-1;
        int level=0;
        while (i<nums.length-1 && nums[i]<nums[i+1]) {
            i++;
        }
        while ( i<j ) {
            if(nums[i]<nums[j]) {
                if(level<nums[i]) {
                    result = result - ((j-i)*level);
                    result = result + ((j-i-1)*nums[i]);
                    level = nums[i];
                }
                else {
                    result = result - nums[i];
                }
                i++;
            }
            else {
                if(level<nums[j]) {
                    result = result - ((j-i)*level);
                    result = result + ((j-i-1)*nums[j]);
                    level = nums[j];
                }
                else {
                    result = result - nums[j];
                }
                j--;
            }
        }

        return result;
    }
}
