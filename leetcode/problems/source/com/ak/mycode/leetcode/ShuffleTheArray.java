package com.ak.mycode.leetcode;

public class ShuffleTheArray {

    public static void main(String[] args) {
        int[] result = new ShuffleTheArray().shuffle(new int[]{1,2,3,4,5,6,7,8,9,10},5);
        for (int i : result) System.out.println(i);
    }

    public int[] shuffle(int[] nums,int n) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int i=0,j=n;i<n;i++,j++) {
            result[index++] = nums[i];
            result[index++] = nums[j];
        }
        return result;
    }

}
