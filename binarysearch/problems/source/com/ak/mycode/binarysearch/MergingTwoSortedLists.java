package com.ak.mycode.binarysearch;

//https://binarysearch.com/problems/Merging-Two-Sorted-Lists

//easy

//array

public class MergingTwoSortedLists {

    public static void main(String[] args) {
        int[] result = new MergingTwoSortedLists().solve(new int[]{5, 10, 15},new int[]{3, 8, 9});
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] solve(int[] a, int[] b) {
        int i = 0, j = 0;
        int[] result = new int[a.length + b.length];
        while (i<a.length && j<b.length) {
            if(a[i]<b[j]) {
                result[i+j] = a[i++];
            }
            else {
                result[i+j] = b[j++];
            }
        }
        while (i<a.length) {
            result[i+j] = a[i++];
        }

        while (j<b.length) {
            result[i+j] = b[j++];
        }
        return result;
    }
}
