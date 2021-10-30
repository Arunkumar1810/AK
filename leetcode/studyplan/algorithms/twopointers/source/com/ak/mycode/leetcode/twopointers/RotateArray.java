package com.ak.mycode.leetcode.twopointers;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        new RotateArray().rotate(nums,3);
        System.out.println("Result : ");
        for (int i : nums) System.out.println(i);
    }

    public void rotate(int[] nums, int k) {
        int numberOfTimesRotated =0;
        int i =0;
        int temp = -1;
        while (numberOfTimesRotated<k || temp!=-1) {
            int tempTemp = nums[i];
            int j = i + k;
            if(nums[i] == -1) j+=1;
            nums[i] = temp;
            if(j>=nums.length) {
                j = j - nums.length;
                numberOfTimesRotated++;
            }
            temp = nums[j];
            nums[j] = tempTemp;
            if(temp == -1) j+=1;
            i=j+k;
            if(i>=nums.length) {
                i = i - nums.length;
                numberOfTimesRotated++;
            }
        }
        if(nums[i]==-1) nums[i] = temp;
    }
}
