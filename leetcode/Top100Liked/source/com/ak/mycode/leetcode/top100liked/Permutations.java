package com.ak.mycode.leetcode.top100liked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/permutations
public class Permutations {

    public static void main(String[] args) {
        List<List<Integer>> results = new Permutations().permute(new int[]{1,2,3});

        for (List<Integer> result: results) {
            System.out.println();
            for (Integer integer : result) {
                System.out.println(integer + "\t");
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(result,nums,0);
        return result;
    }

    private void permute(List<List<Integer>> result, int[] nums, int start) {
        if(start == nums.length-1) {
            List<Integer> singleCombination = new ArrayList<>();
            Arrays.stream(nums).forEach(singleCombination::add);
            result.add(singleCombination);
            return;
        }
        for (int i=start;i<nums.length;i++) {
            swap(nums,start,i);
            permute(result,nums,start+1);
            swap(nums,start,i);
        }
    }

    private void swap(int[] nums, int start, int index) {
        int temp = nums[start];
        nums[start] = nums[index];
        nums[index] = temp;
    }

}
