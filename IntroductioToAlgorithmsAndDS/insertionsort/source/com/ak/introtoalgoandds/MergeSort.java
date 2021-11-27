package com.ak.introtoalgoandds;

//divide and conquer
//recursively split A into L and R (recursively until 1 element) sort merge them.

//Time Complexity - O(n log n) - n for merges and log n for the size of the tree

//Space Complexity - O(n) auxiliary space

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] result = new MergeSort().solve(new int[]{3,2,5,3,7,4,8,10,4,6,3,7});
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] solve(int[] arr) {
        return mergeSort(arr,0,arr.length-1);
    }

    private int[] mergeSort(int[] arr,int start, int end) {
        if(end>start) {
            int mid = start + (end-start) / 2;
            int[] left = mergeSort(arr,start,mid);
            int[] right = mergeSort(arr,mid+1,end);
            return merge(left,right);
        }
        else {
            return new int[]{arr[start]};
        }
    }

    private int[] merge(int[] left, int[] right) {
        int i=0,j=0,k=0;
        int[] result = new int[left.length+right.length];
        while (i<left.length&&j<right.length) {
            if(left[i]<right[j]) {
                result[k++] = left[i++];
            }
            else {
                result[k++] = right[j++];
            }
        }

        while (i<left.length) {
            result[k++] = left[i++];
        }

        while (j<right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}
