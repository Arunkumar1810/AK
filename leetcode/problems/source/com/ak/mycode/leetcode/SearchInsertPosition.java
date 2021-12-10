package com.ak.mycode.leetcode;

//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println("Result : "+new SearchInsertPosition().searchInsert(new int[]{1,3,5,6},7));
    }

    public int searchInsert(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        while (leftIndex<rightIndex) {
            int index = leftIndex + (rightIndex - leftIndex)/2;
            if(nums[index]<target) leftIndex = index + 1;
            else if (nums[index]>target) rightIndex = index;
            else return index;
        }
        if(nums[leftIndex] >= target) return leftIndex;
        return leftIndex+1;
    }
}
