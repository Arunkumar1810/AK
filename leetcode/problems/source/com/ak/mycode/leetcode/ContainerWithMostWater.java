package com.ak.mycode.leetcode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println("Result : "+new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int result = 0;
        int temp;
        for (int i=0,j=height.length-1;i<j;) {
            temp = Math.min(height[i],height[j]) * (j-i);
            result = Math.max(temp,result);
            if(height[i]<height[j]) i++;
            else j--;
        }
        return result;
    }
}

//link - https://leetcode.com/problems/container-with-most-water/

/*
Question : -
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
    Notice that you may not slant the container.
 */

/*
Example : -
    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */

//level - medium

//algorithms used - two pointer

//available in lists - amazon-questions

//Time Complexity - O(n)

//Space Complexity - O(1)