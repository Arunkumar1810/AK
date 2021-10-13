package com.ak.mycode.leetcode.top100liked;

//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println("Result : "+new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int result = 0;
        int temp = 0;
        for (int i=0,j=height.length-1;i<j;) {
            temp = Math.min(height[i],height[j]) * (j-i);
            result = Math.max(temp,result);
            if(height[i]<height[j]) i++;
            else j--;
        }
        return result;
    }
}