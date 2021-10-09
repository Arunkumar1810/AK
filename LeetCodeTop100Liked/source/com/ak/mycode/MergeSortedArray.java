package com.ak.mycode;

//https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        new MergeSortedArray().merge(nums1,nums1.length-nums2.length,nums2,nums2.length);
        for(int num : nums1) {
            System.out.println(num);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m-=1;
        n-=1;
        for (int i=nums1.length-1;i>=0&&n>=0;i--) {
            if(m>=0) {
                if (nums1[m] > nums2[n]) nums1[i] = nums1[m--];
                else nums1[i] = nums2[n--];
            }
            else {
                nums1[i] = nums2[n--];
            }
        }
    }
}
