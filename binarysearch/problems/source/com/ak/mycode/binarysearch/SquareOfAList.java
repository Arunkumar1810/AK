package com.ak.mycode.binarysearch;

//https://binarysearch.com/problems/Square-of-a-List

//Easy

//Two Pointer

//Time Complexity - O(n)

//Space Complexity - O(n)

//Your code took 127 milliseconds — faster than 96.30% in Java

public class SquareOfAList {

    public static void main(String[] args) {
        int[] result = new SquareOfAList().solve(new int[]{-9, -2, 0, 2, 3});
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] solve(int[] nums) {
        int[] result = new int[nums.length];
        for (int i=0,j=nums.length-1,k=nums.length-1;k>=0;k--) {
            if(nums[i]*nums[i] < nums[j]*nums[j]) {
                result[k] = nums[j]*nums[j];
                j--;
            }
            else {
                result[k] = nums[i]*nums[i];
                i++;
            }
        }
        return result;
    }
}
