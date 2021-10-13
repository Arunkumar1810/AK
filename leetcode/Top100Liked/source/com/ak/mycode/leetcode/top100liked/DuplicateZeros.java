package com.ak.mycode.leetcode.top100liked;

//https://leetcode.com/problems/duplicate-zeros
public class DuplicateZeros {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};//result 0 0 1 7 6 0 0 2    0 0 7
        new DuplicateZeros().duplicateZeros(arr);
        for(int el : arr) System.out.println(el);
    }

    public void duplicateZeros(int[] arr) {
        int countOfDups =0;
        for (int k : arr) {
            if (k == 0) countOfDups++;
        }
        for(int i=arr.length-1,j= arr.length-1+countOfDups; i!=j&&i>=0 ; i--,j--) {
            if(j<arr.length) {
                arr[j] = arr[i];
            }
            if(arr[i] == 0) {
                j-=1;
                if(j<arr.length) {
                    arr[j] = arr[i];
                }
            }
        }
    }
}
