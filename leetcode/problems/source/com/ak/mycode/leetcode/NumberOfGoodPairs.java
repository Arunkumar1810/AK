package com.ak.mycode.leetcode;

public class NumberOfGoodPairs {

    public static void main(String[] args) {
        System.out.println(new NumberOfGoodPairs().numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    }

    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[100];
        int[] combinations = new int[100];

        for (int j : nums) {
            int curr = count[j - 1] + 1;
            if (curr == 1) {
                count[j - 1] = 1;
            } else if (curr == 2) {
                count[j - 1] = 2;
                combinations[j - 1] = 1;
            } else {
                count[j - 1] = curr;
                combinations[j - 1] += (curr - 1);
            }
        }
        int result=0;
        for (int num : nums) {
            result += combinations[num - 1];
            combinations[num - 1] = 0;
        }

        return result;
    }
}

//link - https://leetcode.com/problems/number-of-good-pairs/

/*
Question : -
    Given an array of integers nums, return the number of good pairs.
    A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Constraints : -
    1 <= nums.length <= 100
    1 <= nums[i] <= 100
 */

/*
Example : -
    Input: nums = [1,2,3,1,1,3]
    Output: 4
    Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 */

//level - easy

//algorithms used - dp

//available in lists - hash table-tag

//Time Complexity - O(n)

//Space Complexity - O(1)
