package com.ak.mycode.binarysearch;

//https://binarysearch.com/problems/Find-the-Largest-Number-in-a-Rotated-List

//medium

//binary search

//Your code took 83 milliseconds — faster than 94.71% in Java

//Top 100 Liked Problems

public class FindTheLargestNumberInARotatedList {

    public static void main(String[] args) {
        System.out.println(new FindTheLargestNumberInARotatedList().solve(new int[]{1,0}));
    }

    public int solve(int[] arr) {
        return maxNum(arr,0,arr.length-1);
    }

    private int maxNum(int[] arr, int start, int end) {
        if(start==end) return arr[start];
        int index = (start+end)/2;
        if(arr[index+1] <arr[index]) {
            return arr[index];
        }

        if(index-1 >=start && arr[index-1] > arr[index]) {
            return arr[index-1];
        }

        return Math.max(maxNum(arr,start,index),maxNum(arr,index+1,end));
    }

}
