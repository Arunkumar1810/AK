package com.ak.mycode.leetcode.array;

//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresOfASortedArray {

    public static void main(String[] args) {
        int[] input = {-5,-3,-2,-1};
        int[] result = new SquaresOfASortedArray().sortedSquares(input);
        System.out.println("Result : ");
        for(int num : result) {
            System.out.println(num);
        }
    }

    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int front = 0 , back = ans.length-1;
        for(int j=nums.length-1; j>=0 ;j-- ) {
            //if(Math.abs(nums[front]) > Math.abs(nums[back])) {
            if(getAbsValue(nums[front]) > getAbsValue(nums[back])) {
                ans[j] = nums[front]*nums[front];
                front++;
            }
            else {
                ans[j] = nums[back]*nums[back];
                back--;
            }
        }
        return ans;
    }

    public int getAbsValue(int num) {
        if(num<0) {
            return num*-1;
        }
        return num;
    }
}
