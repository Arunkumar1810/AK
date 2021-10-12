package com.ak.mycode;

//https://leetcode.com/problems/binary-search
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("Result : "+new BinarySearch().search(new int[]{5},-5));
    }

    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        while (rightIndex-leftIndex > 1) {
            int index = (leftIndex + rightIndex)/2;
            if(nums[index]<target) leftIndex = index;
            else if (nums[index]>target) rightIndex = index;
            else return index;
        }
        if(nums[leftIndex] == target) return leftIndex;
        if(nums[rightIndex] == target) return rightIndex;
        return -1;
    }
}
