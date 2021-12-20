package com.ak.mycode.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinimumAbsoluteDifference {

    public static void main(String[] args) {
        List<List<Integer>> result = new MinimumAbsoluteDifference().minimumAbsDifference(
                new int[]{4,2,1,3});
        for (List<Integer> pair : result) {
            for (int num : pair) {
                System.out.print(num+ "\t");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new LinkedList<>();
        int minAbsoluteDiff = Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++) {
            int diff = arr[i] - arr[i-1];
            diff = diff<0? diff*-1 : diff;
            if(diff==minAbsoluteDiff) {
                List<Integer> pair = new LinkedList<>();
                pair.add(arr[i-1]);
                pair.add(arr[i]);
                result.add(pair);
            }
            else if(diff<minAbsoluteDiff) {
                result.clear();
                List<Integer> pair = new LinkedList<>();
                pair.add(arr[i-1]);
                pair.add(arr[i]);
                result.add(pair);
                minAbsoluteDiff = diff;
            }
        }
        return result;
    }
}

//link - https://leetcode.com/problems/minimum-absolute-difference/

/*
Question : -
    Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
    Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
        a, b are from arr
        a < b
        b - a equals to the minimum absolute difference of any two elements in arr
 */

/*
Example : -
    Input: arr = [4,2,1,3]
    Output: [[1,2],[2,3],[3,4]]
    Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 */

//level - easy

//algorithms used -

//available in lists -

//Time Complexity - O(n)

//Space Complexity - O(n)
