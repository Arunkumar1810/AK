package com.ak.mycode.leetcode.top100liked;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets
public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> results = subsets.subsets(new int[]{1,2,3});
        for (List<Integer> result : results) {
            System.out.println();
            for (Integer num : result) {
                System.out.print(num + "\t");
            }
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        return getSubSets(nums,new ArrayList<>(),0);
    }

    private List<List<Integer>> getSubSets(int[] nums, List<Integer> list, int indexToStartAdding) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(list);
        for (int i=indexToStartAdding;i<nums.length;i++) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[i]);
            result.addAll(getSubSets(nums,newList,i+1));
        }
        return result;
    }

}
