package com.ak.mycode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][]
                {{1,3},{1,4}};
        int[][] resultIntervals = new MergeIntervals().merge(intervals);
        for (int[] resultInterval : resultIntervals) {
            System.out.println(resultInterval[0] + "\t" + resultInterval[1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        quickSort(intervals,0,intervals.length-1);
        List<Integer[]> resultList = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(currStart>end) {
                Integer[] interval = new Integer[2];
                interval[0] = start;
                interval[1] = end;
                start = currStart;
                end = currEnd;
                resultList.add(interval);
            }
            else {
                if(currEnd>end) {
                    end = currEnd;
                }
            }
        }
        int[][] result = new int[resultList.size()+1][2];
        for(int i=0;i<resultList.size();i++) {
            Integer[] res = resultList.get(i);
            result[i][0] = res[0];
            result[i][1] = res[1];
        }
        result[result.length-1][0] = start;
        result[result.length-1][1] = end;
        return result;
    }

    public void quickSort(int[][] arr,int start,int end) {
        if(start<0||start>=end||end>=arr.length) return;
        int pivot = arr[end][0];
        int i=start,j=end-1;
        while(i<j) {
            if(arr[i][0]<pivot) {
                i++;
            }
            else {
                if(arr[j][0]>=pivot) {
                    j--;
                }
                else {
                    int temp0 = arr[i][0];
                    int temp1 = arr[i][1];
                    arr[i][0] = arr[j][0];
                    arr[i][1] = arr[j][1];
                    arr[j][0] = temp0;
                    arr[j][1] = temp1;
                }
            }
        }

        if(arr[i][0]>=pivot) {
            int temp0 = arr[end][0];
            int temp1 = arr[end][1];
            arr[end][0] = arr[i][0];
            arr[end][1] = arr[i][1];
            arr[i][0] = temp0;
            arr[i][1] = temp1;
            quickSort(arr,start,i-1);
            quickSort(arr,i+1,end);
        }
        else {
            quickSort(arr,start,i);
        }

    }
}

//link - https://leetcode.com/problems/merge-intervals/submissions/

/*
Question : -
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */

/*
Example : -
    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */

//level - medium

//algorithms used -

//available in lists -

//Time Complexity - O(n log n)

//Space Complexity - O(n)
