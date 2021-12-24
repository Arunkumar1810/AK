package com.ak.mycode.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {

    public static void main(String[] args) {
        List<Integer> result = new FindTargetIndicesAfterSortingArray().targetIndices(new int[] {1,2,5,2,3},2);
        for (Integer i : result) System.out.println(i);
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int start = binarySearch(nums,target,0,nums.length-1);
        List<Integer> result = new LinkedList<>();
        for(int i=start;i<nums.length && i>=0;i++) {
            if(nums[i]==target) {
                result.add(i);
            }
            else break;
        }
        return result;
    }

    public int binarySearch(int[] nums,int target,int start, int end) {
        if(start>end) return -1;

        int middle = (start+end)/2;

        if(nums[middle]==target)
        {
            for(int i=middle;i>=0;i--) {
                if(nums[i]!=target) return i+1;
            }
            return 0;
        }
        else if(nums[middle]<target) return binarySearch(nums,target,middle+1,end);
        else return binarySearch(nums,target,start,middle-1);
    }
}

//link - https://leetcode.com/problems/find-target-indices-after-sorting-array/

/*
Question : -
    You are given a 0-indexed integer array nums and a target element target.
    A target index is an index i such that nums[i] == target.
    Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
 */

/*
Example : -
    Input: nums = [1,2,5,2,3], target = 2
    Output: [1,2]
    Explanation: After sorting, nums is [1,2,2,3,5].
        The indices where nums[i] == 2 are 1 and 2.
 */

//level - easy

//algorithms used -

//available in lists - sorting-tag

//Time Complexity - O(n log n)

//Space Complexity - O(1)