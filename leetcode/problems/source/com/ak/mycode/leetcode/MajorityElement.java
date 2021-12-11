package com.ak.mycode.leetcode;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{3,3,4}));
    }

    public int majorityElement(int[] nums) {
        int majorNum = nums[0],count=1;
        for (int i =1;i<nums.length;i++) {
            if(majorNum!=nums[i]) {
                count--;
            }
            else {
                count++;
            }
            if(count==0) {
                majorNum = nums[i];
                count=1;
            }
        }
        return majorNum;
    }
}

//link - https://leetcode.com/problems/majority-element/

/*
Question : -
    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Constraints:
    n == nums.length
    1 <= n <= 5 * 104
    -231 <= nums[i] <= 231 - 1
 */

/*
Example : -
    Input: nums = [3,2,3]
    Output: 3
 */

//level - easy

//algorithms used - mathematics-counting

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(1)