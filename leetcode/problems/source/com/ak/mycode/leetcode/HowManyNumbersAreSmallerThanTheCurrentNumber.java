package com.ak.mycode.leetcode;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    public static void main(String[] args) {
        int[] result = new HowManyNumbersAreSmallerThanTheCurrentNumber().smallerNumbersThanCurrent(new int[]{6,5,4,8});
        for (int i : result) System.out.println(i);
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        int[] sortedArr = new int[nums.length];
        System.arraycopy(nums, 0, sortedArr, 0, nums.length);
        sortedArr = quickSort(sortedArr,0,nums.length-1);
        for(int i=0;i<nums.length;i++) {
            int val = nums[i];
            int index = binarySearch(sortedArr,val,0,nums.length-1);
            result[i] = index;
        }
        return result;
    }

    private int binarySearch(int[] arr,int val,int start,int end) {
        if(start>end) return -1;
        int mid = (start + end)/2;
        if(arr[mid] == val) {
            while(mid-1>=0 && arr[mid-1]==val) mid--;
            return mid;
        }
        else if(arr[mid]<val) {
            return binarySearch(arr,val,mid+1,end);
        }
        else {
            return binarySearch(arr,val,start,mid-1);
        }

    }

    private int[] quickSort(int[] arr,int start,int end) {
        if(start>end) return arr;
        int pivot = arr[end];
        int newPivotPosition = start-1;

        for (int i=start;i<=end-1;i++) {
            if(arr[i] < pivot) {
                newPivotPosition++;
                int temp = arr[i];
                arr[i] = arr[newPivotPosition];
                arr[newPivotPosition] = temp;
            }
        }
        int temp = arr[newPivotPosition+1];
        arr[newPivotPosition+1] = arr[end];
        arr[end] = temp;

        arr = quickSort(arr,start,newPivotPosition);
        arr = quickSort(arr,newPivotPosition+2,end);
        return arr;
    }
}

//link - https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

/*
Question : -
    Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
    Return the answer in an array.
 */

/*
Example : -
    Input: nums = [8,1,2,2,3]
    Output: [4,0,1,1,3]
    Explanation:
    For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
    For nums[1]=1 does not exist any smaller number than it.
    For nums[2]=2 there exist one smaller number than it (1).
    For nums[3]=2 there exist one smaller number than it (1).
    For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 */

//level - easy

//algorithms used - quicksort, binary search

//available in lists - hash table-tag

//Time Complexity - O(n log n)

//Space Complexity - O(n)