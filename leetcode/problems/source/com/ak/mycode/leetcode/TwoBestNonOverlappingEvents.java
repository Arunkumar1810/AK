package com.ak.mycode.leetcode;

import java.util.*;

public class TwoBestNonOverlappingEvents {
    public static void main(String[] args) {
        System.out.println(new TwoBestNonOverlappingEvents().maxTwoEvents(new int[][]{
                {1,3,2},
                {4,5,2},
                {2,4,3},
                {4,8,2},
                {6,8,2}
        }));
    }

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int maxValue= 0, n= events.length;
        TreeMap<Integer,Integer> sMax= new TreeMap<>();
        for(int i=n-1; i>=0; i--)
            if(events[i][2]>maxValue)
                sMax.put(events[i][0], maxValue= events[i][2]);
        int maxTwo= 0;
        for(int[] e:events){
            Map.Entry<Integer,Integer> maxOne= sMax.ceilingEntry(e[1]+1);
            maxTwo= Math.max(maxTwo, e[2] + (maxOne!=null ? maxOne.getValue() : 0));
        }
        return maxTwo;
    }
}

//link - https://leetcode.com/problems/two-best-non-overlapping-events/

/*
Question : -
    You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei]. The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei. You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.
    Return this maximum sum.
    Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts and the other ends at the same time. More specifically, if you attend an event with end time t, the next event must start at or after t + 1.

Constraints:
    2 <= events.length <= 105
    events[i].length == 3
    1 <= startTimei <= endTimei <= 109
    1 <= valuei <= 106
 */

/*
Example : -
    Input: events = [[1,3,2],[4,5,2],[1,5,5]]
    Output: 5
    Explanation: Choose event 2 for a sum of 5.
 */

//level - medium

//algorithms used - tree map

//available in lists -

//Time Complexity - O(n log n)

//Space Complexity - O(n)