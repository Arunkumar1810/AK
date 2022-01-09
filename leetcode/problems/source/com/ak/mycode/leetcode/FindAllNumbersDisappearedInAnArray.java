package com.ak.mycode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray obj = new FindAllNumbersDisappearedInAnArray();
        List<Integer> result = obj.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        for (Integer i : result) System.out.println(i);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0 ;i<nums.length;i++) {
            while(nums[i]!=-1 && nums[nums[i]-1]!=-1) {
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = -1;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=-1) {
                result.add(i+1);
            }
        }
        return result;
    }
}

//link - https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

/*
Question : -
    Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
    Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */

/*
Example : -
    Input: nums = [4,3,2,7,8,2,3,1]
    Output: [5,6]
 */

//level - easy

//algorithms used -

//available in lists - amazon-questions

//Time Complexity - O(n)

//Space Complexity - O(1)
