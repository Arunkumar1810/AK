package com.ak.mycode.leetcode;

import java.util.*;

public class LargestDivisibleSubset {

    public static void main(String[] args) {
        List<Integer> result = new LargestDivisibleSubset().largestDivisibleSubset(new int[]{1,2,3});
        for (int i : result) {
            System.out.println(i);
        }
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length==0) new ArrayList<>();
        Arrays.sort(nums);
        int[] numOfDivisors = new int[nums.length];
        int[] prev = new int[nums.length];
        prev[0]=-1;
        int max=0,index=0;
        for (int i=1; i<nums.length;i++) {
            prev[i]=-1;
            for (int j=i-1;j>=0;j--) {
                if(numOfDivisors[j]+1>numOfDivisors[i] && nums[i]%nums[j]==0) {
                    numOfDivisors[i] = numOfDivisors[j]+1;
                    prev[i] = j;
                    if(max<numOfDivisors[i]) {
                        max = numOfDivisors[i];
                        index = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (index!=-1) {
            result.add(nums[index]);
            index = prev[index];
        }
        return result;
    }

}

//link - https://leetcode.com/problems/largest-divisible-subset/

/*
Question : -
    Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
    answer[i] % answer[j] == 0, or
    answer[j] % answer[i] == 0
    If there are multiple solutions, return any of them.

Constraints : -
    1 <= nums.length <= 1000
    1 <= nums[i] <= 2 * 109
    All the integers in nums are unique.
 */

/*
Example : -
    Input: nums = [1,2,3]
    Output: [1,2]
    Explanation: [1,3] is also accepted.
 */

//level - medium

//algorithms used - DP - Tabulation

//available in lists -

//Time Complexity - O(n^2)

//Space Complexity - O(n)
